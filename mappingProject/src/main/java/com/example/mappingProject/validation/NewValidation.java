package com.example.mappingProject.validation;

import com.example.mappingProject.models.Address;
import com.example.mappingProject.models.UserModel;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
@Component
public class NewValidation implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return UserModel.class.equals(clazz);
    }


    @Override
    public void validate(Object target, Errors errors) {
        UserModel userModel = (UserModel) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "UserName", "Username must not be empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "Password", "Password must not be empty");

        if(userModel.getFirstName() != null && !userModel.getFirstName().isEmpty() && userModel.getFirstName().length() < 5) {
            errors.rejectValue("firstName", "firstNameSize", "At least 5 characters required for First Name");
        } else {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "FirstName", "First Name must not be empty");
        }

        if (userModel.getLastName() != null && !userModel.getLastName().isEmpty() && userModel.getLastName().length() < 4) {
            errors.rejectValue("lastName", "lastNameSize", "At least 4 characters required for Last Name");
        } else {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "LastName", "Last Name must not be empty");
        }

        Address address = userModel.getAddress();
        if (address != null) {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address.street", "StreetEmpty", "Street must not be empty");
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address.city", "CityEmpty", "City must not be empty");
        }
    }
}