package com.itau.pixkey.entrypoint.api.controller.validation;

import com.itau.pixkey.core.domain.KeyType;
import com.itau.pixkey.core.validation.PixKeyValidation;
import com.itau.pixkey.entrypoint.api.controller.payload.input.PixKeyInput;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RequiredArgsConstructor
public class PixKeyValidator implements ConstraintValidator<PixKey, PixKeyInput>  {

    private final Map<KeyType, PixKeyValidation> pixKeyValidationMap;

    @Override
    public void initialize(PixKey constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(PixKeyInput pixKeyInput, ConstraintValidatorContext constraintValidatorContext) {
        var isValid = pixKeyValidationMap.get(pixKeyInput.getKeyType()).validate(pixKeyInput.getKeyValue(), constraintValidatorContext);

        if (!isValid) {
            constraintValidatorContext.disableDefaultConstraintViolation();
        }

        return isValid;
    }



}
