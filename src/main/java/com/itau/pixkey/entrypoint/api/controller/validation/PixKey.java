package com.itau.pixkey.entrypoint.api.controller.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target(ElementType.TYPE)
@Retention(RUNTIME)
@Constraint(validatedBy = PixKeyValidator.class)
public @interface PixKey {

    String message() default "Invalid pix key";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };

}
