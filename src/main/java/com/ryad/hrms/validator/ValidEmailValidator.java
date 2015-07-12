package com.ryad.hrms.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.ryad.hrms.annotation.ValidEmail;

public class ValidEmailValidator implements ConstraintValidator<ValidEmail, String> {
	
	private Pattern pattern;
    private Matcher matcher;
    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-+]+(.[_A-Za-z0-9-]+)*@" + 
    		"[A-Za-z0-9-]+(.[A-Za-z0-9]+)*(.[A-Za-z]{2,})$"; 
	
	@Override
    public void initialize(ValidEmail validEmail) {        
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return (validateEmail(value));
    }
    
    private boolean validateEmail(String email) {
    	if(email == null || email.isEmpty()) {
    		return true;
    	}
    	
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(email);
        return matcher.matches();
    }
}