package com.example.mappingProject.validation;

import com.example.mappingProject.models.AdminModel;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class AdminValidation implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return AdminModel.class.equals(clazz);
    }
    @Override
    public void validate(Object target, Errors errors) {
        AdminModel adminModel=(AdminModel) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"username","adminUsername","Username must not be empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"password","adminPassword","password must not be empty");
        if(adminModel.getUsername()!=null && ( adminModel.getUsername().length()<5 || adminModel.getUsername().length()>15)){
            errors.rejectValue("username","adminUserNameSize");
        }
        if(adminModel.getPassword()!=null && ( adminModel.getPassword().length()<5 || adminModel.getPassword().length()>15)){
            errors.rejectValue("password","adminPasswordSize");
        }
    }
}
