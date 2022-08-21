package com.example.webbanquanao.controller.backdend;


import com.example.webbanquanao.dto.ProductDto;
import com.example.webbanquanao.utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

@Controller
@RequestMapping("/backend/product")
public class ProductController {

    @RequestMapping("create")
    public String create(Model model) throws Exception{
        ProductDto dto = new ProductDto();
        model.addAttribute("productDto", dto);
        return "backend/product/create";
    }

    @PostMapping("upload")
    @ResponseBody
    public String upload(@RequestParam("file")MultipartFile file) throws Exception{
        return FileUtils.saveFile(file);
    }

    @RequestMapping(value = "save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String save(@Valid @ModelAttribute ProductDto productDto,
                       BindingResult bindingResult,
                       RedirectAttributes model) throws Exception{
        if (bindingResult.hasErrors()) {
            return "backend/product/create";
        }
        saveDb(productDto);
        model.addFlashAttribute("message", "Lưu sản phẩm thành công");
        return "redirect:/backend/product/create";
    }

    void saveDb(ProductDto productDto) throws Exception {
        Connection connection = DriverManager.getConnection(UserController.URL,
                UserController.USER, UserController.PASS);

        String queryString = "insert into product (NAME, DESCRIPTION, IMAGE, PRICE ) value (?,?,?,?)" ;
        PreparedStatement pst = connection.prepareStatement(queryString);
        pst.setString(1, productDto.getName());
        pst.setString(2, productDto.getDescription());
        pst.setString(3, productDto.getImage());
        pst.setLong(4, productDto.getPrice());
        pst.executeUpdate();
        connection.close();
        pst.close();
    }

}

