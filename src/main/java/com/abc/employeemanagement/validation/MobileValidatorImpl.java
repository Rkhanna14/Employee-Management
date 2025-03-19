package com.abc.employeemanagement.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class MobileValidatorImpl implements ConstraintValidator<Mobile, String>{

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		if(value == null || value.isEmpty())
			return false;
		return value.matches("[6-9]{1}[0-9]{9}");
	}

}
