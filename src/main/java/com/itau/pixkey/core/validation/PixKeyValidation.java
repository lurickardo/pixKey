package com.itau.pixkey.core.validation;

import jakarta.validation.ConstraintValidatorContext;

public interface PixKeyValidation {

    Boolean validate(String keyValue, ConstraintValidatorContext constraintValidatorContext);

}
