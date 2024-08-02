package com.consultoria.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NoSpecialCharsValidator implements ConstraintValidator<NoSpecialChars, String> {

    private static final String SPECIAL_CHARS = "<>/?\\[\\]{}*\\-+&@#\\$%";

    @Override
    public void initialize(NoSpecialChars constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }

        return !value.matches(".*[" + SPECIAL_CHARS + "].*");
    }
}