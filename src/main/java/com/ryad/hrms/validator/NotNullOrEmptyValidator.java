package com.ryad.hrms.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.ryad.hrms.annotation.NotNullOrEmpty;

public class NotNullOrEmptyValidator implements ConstraintValidator<NotNullOrEmpty, Object> {
	
	@Override
    public void initialize(NotNullOrEmpty notNullOrEmpty) {
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        //return !(value == null || value.isEmpty());
    	boolean result = false;
    	
    	if(value instanceof String) {
    		result = !(value == null || ((String)value).isEmpty());
    	} else {
    		result = (value != null);
    	}
    	
    	return result;
    }
}