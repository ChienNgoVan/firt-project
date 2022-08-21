package com.example.webbanquanao.controller.backdend;


import com.example.webbanquanao.dto.UserDto;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("backend/user")
public class UserController {

    public static String URL = "jdbc:mysql://localhost:3306/2206";
    public static String USER = "root";
    public static String PASS = "1234";

    @RequestMapping("list")
    public String list(Model model) throws Exception{
        List<UserDto> userDtoList = new ArrayList<>();
        Connection connection = DriverManager.getConnection(URL, USER, PASS);

        String queryString = "select * from user";
        PreparedStatement pst = connection.prepareStatement(queryString);
        ResultSet resultSet = pst.executeQuery();
        while (resultSet.next()) {
            Long id = resultSet.getLong("ID");
            String name = resultSet.getString("FULL_NAME");
            String email = resultSet.getString("EMAIL");
            String password = resultSet.getString("PASSWORD");
            String role = resultSet.getString("ROLE");
            String address = resultSet.getString("ADDRESS");
            Long phone = resultSet.getLong("PHONE");
            userDtoList.add(new UserDto(id, name, email, password, role, address,phone,null));
        }
        connection.close();
        pst.close();

        model.addAttribute("list", userDtoList);
        return "backend/user/user_list";
    }

    @RequestMapping("detail/{id}")
    public String detail(Model model, @PathVariable Long id) throws Exception{
        model.addAttribute("user", detailById(id));
        return "backend/user/user_detail";
    }

    @RequestMapping("rest-detail/{id}")
    @ResponseBody
    public UserDto getDetail( @PathVariable Long id) throws Exception{
        return detailById(id);
    }

    @RequestMapping("create")
    public String create(Model model) throws Exception{
        UserDto dto = new UserDto();
        model.addAttribute("userDto", dto);
        return "backend/user/user_create";
    }


    @RequestMapping(value = "save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String save(@Valid @ModelAttribute UserDto userDto,
                       BindingResult bindingResult,
                       RedirectAttributes model) throws Exception{
        if (bindingResult.hasErrors()) {
            return "backend/user/user_create";
        }
        saveDb(userDto);
        model.addFlashAttribute("message", "Lưu tài khoản thành công");
        return "backend/user/user_create";
    }

    @RequestMapping(value = "save-body", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String saveBody(@RequestBody UserDto userDto) throws Exception{
        saveDb(userDto);
        return "Lưu tài khoản thành công";
    }


    UserDto detailById(Long id) throws Exception {
        UserDto userDto = null;
        Connection connection = DriverManager.getConnection(URL, USER, PASS);

        String queryString = "select * from user where ID = ?" ;
        PreparedStatement pst = connection.prepareStatement(queryString);
        pst.setLong(1, id);
        ResultSet resultSet = pst.executeQuery();
        while (resultSet.next()) {
            String name = resultSet.getString("FULL_NAME");
            String email = resultSet.getString("EMAIL");
            String password = resultSet.getString("PASSWORD");
            String role = resultSet.getString("ROLE");
            String address = resultSet.getString("ADDRESS");
            Long phone = resultSet.getLong("PHONE");
            userDto = new UserDto(id, name, email, password,role,address,phone, null);
            if (userDto != null) break;
        }
        connection.close();
        pst.close();
        return userDto;
    }

    void saveDb(UserDto userDto) throws Exception {
        Connection connection = DriverManager.getConnection(URL, USER, PASS);

        String queryString = "insert into user (FULL_NAME, EMAIL, PASSWORD,ROLE ,ADDRESS,PHONE) value (?,?,?,?,?,?)" ;
        PreparedStatement pst = connection.prepareStatement(queryString);
        pst.setString(1, userDto.getFullName());
        pst.setString(2, userDto.getEmail());
        pst.setString(3, userDto.getPassword());
        pst.setString(4, userDto.getRole());
        pst.setString(5, userDto.getAddress());
        pst.setLong(6, userDto.getPhone());
        pst.executeUpdate();
        connection.close();
        pst.close();
    }
}
