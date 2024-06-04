package com.itau.pixkey.core.validation;

import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component
public class CellPhoneValidation implements PixKeyValidation {

    @Override
    public Boolean validate(String keyValue, ConstraintValidatorContext constraintValidatorContext) {
        var regexCellPhone = "^\\+\\d{12,15}";
        var isValid = keyValue.matches(regexCellPhone);

        if (!isValid) {
            constraintValidatorContext.buildConstraintViolationWithTemplate("Mobile number must have country code, area code and 9-digit mobile number").addConstraintViolation();
        }

        return isValid;
    }

}
