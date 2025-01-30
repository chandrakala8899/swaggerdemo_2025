package com.neoteric.swaggerdemo_2025.customvalidations;

import com.neoteric.swaggerdemo_2025.customvalidations.DateRangeValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = DateRangeValidator.class)
@Target(ElementType.TYPE) // Apply at class level
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidDateRange {
    String message() default "From Date cannot be after To Date";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
