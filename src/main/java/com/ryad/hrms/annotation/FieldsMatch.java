package com.ryad.hrms.annotation;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.ryad.hrms.validator.FieldsMatchValidator;

@Target({TYPE, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = FieldsMatchValidator.class)
public @interface FieldsMatch {
	String message() default "{fieldName1} and {fieldName2} don't match.";
    Class<?>[] groups() default {}; 
    Class<? extends Payload>[] payload() default {};
    String field1() default "";
    String field2() default "";    
    String fieldName1() default "";
    String fieldName2() default "";
}