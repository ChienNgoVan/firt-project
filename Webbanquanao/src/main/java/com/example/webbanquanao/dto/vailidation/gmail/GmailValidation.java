package com.example.webbanquanao.dto.vailidation.gmail;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class GmailValidation implements ConstraintValidator<GmailIF, String> {
        @Override
        public boolean isValid(String value, ConstraintValidatorContext context) {
            return value.endsWith("@gmail.com");
        }
    }


