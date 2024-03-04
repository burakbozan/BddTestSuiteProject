package com.ing.suiteapi.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = GherkinSyntaxValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidGherkinSyntax {

    String message() default "Invalid Gherkin syntax";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};


}