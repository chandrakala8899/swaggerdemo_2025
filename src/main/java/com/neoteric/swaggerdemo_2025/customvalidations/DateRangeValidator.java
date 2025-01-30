package com.neoteric.swaggerdemo_2025.customvalidations;

import com.neoteric.swaggerdemo_2025.entity.Customer;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class DateRangeValidator implements ConstraintValidator<ValidDateRange, Customer> {

    @Override
    public boolean isValid(Customer customer, ConstraintValidatorContext context) {
        // Handle cases where fromDate or toDate is null
        if (customer == null || customer.getFromDate() == null || customer.getToDate() == null) {
            return true; // Let @NotNull handle null validation separately
        }

        // Check if fromDate is after toDate
        if (customer.getFromDate().after(customer.getToDate())) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("From Date cannot be after To Date")
                    .addPropertyNode("fromDate") // Attach error to the fromDate field
                    .addConstraintViolation();
            return false;
        }

        return true; // Validation passed
    }
}

