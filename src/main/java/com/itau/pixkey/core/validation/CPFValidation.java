package com.itau.pixkey.core.validation;

import com.itau.pixkey.core.gateway.ValidatorGateway;
import com.itau.pixkey.entrypoint.libraries.StellaService;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.ValidatorFactory;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CPFValidator;
import org.hibernate.validator.internal.engine.ValidatorFactoryImpl;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CPFValidation implements PixKeyValidation {

    private final ValidatorGateway validatorGateway;

    @Override
    public Boolean validate(String keyValue, ConstraintValidatorContext constraintValidatorContext) {
        var isValid = validatorGateway.cpfIsValid(keyValue);

        if (!isValid) {
            constraintValidatorContext.buildConstraintViolationWithTemplate("Invalid CPF").addConstraintViolation();
        }

        return isValid;
    }

}
