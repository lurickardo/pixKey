package com.itau.pixkey.core.validation;

import com.itau.pixkey.core.gateway.ValidatorGateway;
import com.itau.pixkey.entrypoint.libraries.StellaService;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CNPJValidator;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CNPJValidation implements PixKeyValidation {

    private final ValidatorGateway validatorGateway;

    @Override
    public Boolean validate(String keyValue, ConstraintValidatorContext constraintValidatorContext) {
        var isValid = validatorGateway.cnpjIsValid(keyValue);

        if (!isValid) {
            constraintValidatorContext.buildConstraintViolationWithTemplate("Invalid CNPJ").addConstraintViolation();
        }

        return isValid;
    }

}
