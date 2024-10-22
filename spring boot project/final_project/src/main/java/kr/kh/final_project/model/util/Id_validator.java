package kr.kh.final_project.model.util;

import org.springframework.beans.factory.annotation.Autowired;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import kr.kh.final_project.service.UserService;

public class Id_validator implements ConstraintValidator<Check_id, String> {
	
	@Autowired
	private UserService userService;
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if(value == null) {
			return true;
		}
		boolean flag = userService.check_is_in(value);
		return flag;
	}



}
