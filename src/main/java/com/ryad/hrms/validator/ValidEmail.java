package com.ryad.hrms.validator;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({FIELD, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = ValidEmailValidator.class)
public @interface ValidEmail {
	String message() default "Please enter a valid email.";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
    String fieldName() default "";
}