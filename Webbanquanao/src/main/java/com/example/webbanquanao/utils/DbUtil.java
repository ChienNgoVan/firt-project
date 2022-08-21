package com.example.webbanquanao.utils;

import com.example.webbanquanao.controller.backdend.UserController;
import com.example.webbanquanao.dto.ProductDto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DbUtil {

    public static List<ProductDto> danhSachSanPham(){
        List<ProductDto> userDtoList = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(UserController.URL, UserController.USER, UserController.PASS);

            String queryString = "select * from product";
            PreparedStatement pst = connection.prepareStatement(queryString);
            ResultSet resultSet = pst.executeQuery();
            while (resultSet.next()) {
                Long id = resultSet.getLong("ID");
                Long price = resultSet.getLong("PRICE");
                String name = resultSet.getString("NAME");
                String description = resultSet.getString("DESCRIPTION");
                String image = resultSet.getString("IMAGE");
                userDtoList.add(new ProductDto(id, price, name, description, image));
            }
            connection.close();
            pst.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return  userDtoList;
    }

}
