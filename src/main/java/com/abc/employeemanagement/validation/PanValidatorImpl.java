package com.abc.employeemanagement.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PanValidatorImpl implements ConstraintValidator<Pan, String>{

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		if(value == null || value.isEmpty())
			return false;
		return value.matches("[A-Z]{5}[0-9]{4}[A-Z]{1}");
	}

}
