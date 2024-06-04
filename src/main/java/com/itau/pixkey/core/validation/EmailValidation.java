package com.itau.pixkey.core.validation;

import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

@Component
public class EmailValidation implements PixKeyValidation {

    @Override
    public Boolean validate(String keyValue, ConstraintValidatorContext constraintValidatorContext) {
        var regexEmail = "[a-zA-Z\\d]+@[a-zA-Z\\d]+\\.[a-z\\d]+";
        var isValid = keyValue.matches(regexEmail);

        if (!isValid) {
            constraintValidatorContext.buildConstraintViolationWithTemplate("Email can only contain letters, numbers, @ and period").addConstraintViolation();
        }

        return isValid;
    }

}
