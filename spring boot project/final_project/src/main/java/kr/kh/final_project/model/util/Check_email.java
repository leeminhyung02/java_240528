package kr.kh.final_project.model.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;

@Target(ElementType.FIELD) // 1
@Retention(RetentionPolicy.RUNTIME) // 2
@Constraint(validatedBy = Email_validator.class) // 3
public @interface Check_email {
	  String message() default "이미 해당 email(이)가 있습니다."; // 4
	  Class[] groups() default {};
	  Class[] payload() default {};
}
