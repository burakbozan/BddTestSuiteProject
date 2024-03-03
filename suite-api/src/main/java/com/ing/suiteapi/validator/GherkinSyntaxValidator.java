package com.ing.suiteapi.validator;

import com.ing.suiteapi.util.GherkinUtils;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class GherkinSyntaxValidator implements ConstraintValidator<ValidGherkinSyntax, String> {

    @Override
    public void initialize(ValidGherkinSyntax constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.isBlank()) {
            return true;
        }

        return GherkinUtils.isValidGherkinSyntax(value);
    }
}
