package com.reylibutan.tabularasa.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NotNullOrEmptyValidator implements ConstraintValidator<NotNullOrEmpty, String> {
	
	@Override
    public void initialize(NotNullOrEmpty notNullOrEmpty) {        
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return !(value == null || value.isEmpty());
    }
}