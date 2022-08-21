package com.example.webbanquanao.dto;

import com.example.webbanquanao.dto.vailidation.gmail.GmailIF;
import com.example.webbanquanao.dto.vailidation.password.PasswordAnotation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data // tự động sinh ra các hàm getter setter
@AllArgsConstructor
@NoArgsConstructor
@PasswordAnotation(message = "Mật khẩu không trùng khớp")
public class UserDto {
    private Long id;
    @NotBlank(message = "Họ tên không được rỗng")
    @NotNull
    @NotEmpty
    private String fullName;
    @Email(message = "Vui lòng nhập đúng dạng email")
    @NotBlank(message = "Email bắt buộc phải nhập")
    @GmailIF
    private String email;
    @NotBlank(message = "Mật khẩu bắt buộc phải nhập")
    private String password;
    @NotBlank(message = "Nhập lại password bắt buộc phải nhập")
    private String role;
    private String address;
    private Long phone;
    private String rePassword;
}
