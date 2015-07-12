package com.ryad.hrms.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.ryad.hrms.annotation.NotNullOrEmpty;

public class NotNullOrEmptyValidator implements ConstraintValidator<NotNullOrEmpty, String> {
	
	@Override
    public void initialize(NotNullOrEmpty notNullOrEmpty) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return !(value == null || value.isEmpty());
    }
}