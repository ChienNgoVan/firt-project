package com.example.webbanquanao.dto.vailidation.password;


import com.example.webbanquanao.dto.UserDto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordValidation  implements ConstraintValidator<PasswordAnotation, UserDto> {

    @Override
    public boolean isValid(UserDto value, ConstraintValidatorContext Context) {
        return value.getPassword().equals(value.getRePassword());
    }
}


