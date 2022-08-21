package com.example.webbanquanao.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ProductDto {
    Long id;
   @NotNull(message = "Giá bắt buộc phải điền")
   @Min(value = 0, message = "Giá ngỏ nhất là 0")
    Long price;
    String name;
   @NotBlank(message = "Mô tả không được rỗng")
    String description;
    String image;
   public ProductDto(Long id, String name, String description, Long price, String image) {
   }

}
