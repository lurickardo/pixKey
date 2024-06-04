package com.itau.pixkey.core.validation;

import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

@Component
public class RandomKeyValidation implements PixKeyValidation {

    //TODO faz a regra máxima de caracteres ser dinamica, definida por variavel de ambiente?
    @Override
    public Boolean validate(String keyValue, ConstraintValidatorContext constraintValidatorContext) {
        var characterLimit = 36;
        var regexRandomKey = String.format("[a-zA-Z\\d]{%d}", characterLimit);
        var isValid = keyValue.matches(regexRandomKey);

        if (!isValid) {
            constraintValidatorContext.buildConstraintViolationWithTemplate(String.format("Random key can only have letters and numbers and cannot exceed %d characters", characterLimit)).addConstraintViolation();
        }

        return isValid;
    }

}
