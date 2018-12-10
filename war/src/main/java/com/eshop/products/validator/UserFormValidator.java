package com.eshop.products.validator;

import com.eshop.products.entities.Account;
import com.eshop.products.model.CustomerInfo;
import com.eshop.products.services.UserService;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class UserFormValidator implements Validator{
    @Autowired
    UserService userService;

    public boolean supports(Class<?> clazz) {
        return Account.class.isAssignableFrom(clazz);
    }

    private EmailValidator emailValidator = EmailValidator.getInstance();

    public void validate(Object target, Errors errors) {
        Account account = (Account) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login", "NotEmpty.registerForm.login");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty.registerForm.password");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty.registerForm.email");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phone", "NotEmpty.registerForm.phone");
        if (!emailValidator.isValid(account.getEmail())) {
            errors.rejectValue("email", "Pattern.registerForm.email");
        }
        if (account.getLogin().length() > 20) {
            errors.rejectValue("login", "Pattern.registerForm.login");
        }
        if (account.getPassword().length() > 20) {
            errors.rejectValue("password", "Pattern.registerForm.password");
        }
    }

    public void validateLogin(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login", "NotEmpty.loginForm.login");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty.loginForm.password");
    }
}
