package edu.jhu.project.thegameshop.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import edu.jhu.project.thegameshop.model.User;

public class UserValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}

	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		User user = (User) target;
		user.getAddress1();
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "user.username.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "user.password.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "user.firstname.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "user.lastname.empty");
	}

}
