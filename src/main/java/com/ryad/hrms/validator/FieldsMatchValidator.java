package com.ryad.hrms.validator;

import java.lang.reflect.Field;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FieldsMatchValidator implements ConstraintValidator<FieldsMatch, Object> {
	
	private String fieldName1;
	private String fieldName2;
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public void initialize(FieldsMatch fieldsMatch) {
		this.fieldName1 = fieldsMatch.field1();
		this.fieldName2 = fieldsMatch.field2();
	}

	@Override
	public boolean isValid(Object obj, ConstraintValidatorContext arg1) {
		boolean result = true;
		
		try {
			Field field1 = obj.getClass().getDeclaredField(fieldName1);
			Field field2 = obj.getClass().getDeclaredField(fieldName2);
			
			String fieldValue1 = (String) field1.get(obj);
			String fieldValue2 = (String) field2.get(obj);
			
			if(!(fieldValue1 == null || fieldValue2 == null)) {
				result = fieldValue1.equals(fieldValue2);
			}
		} catch (Exception e) {
			log.debug(e.getMessage());
		}
		
		return result;
	}
}