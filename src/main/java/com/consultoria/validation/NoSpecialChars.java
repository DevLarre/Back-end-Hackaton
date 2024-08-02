package com.consultoria.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = NoSpecialCharsValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface NoSpecialChars {
    String message() default "O campo contém caracteres especiais inválidos";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
