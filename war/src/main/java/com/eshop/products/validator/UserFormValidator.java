package com.eshop.products.validator;

import com.eshop.products.entities.Account;
import com.eshop.products.model.CustomerInfo;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserFormValidator implements Validator{

    public boolean supports(Class<?> clazz) {
        return clazz == CustomerInfo.class;
    }

    private EmailValidator emailValidator = EmailValidator.getInstance();

    public void validate(Object target, Errors errors) {
        Account account = (Account) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty.customerForm.name");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty.customerForm.email");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", "NotEmpty.customerForm.address");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phone", "NotEmpty.customerForm.phone");

        if (!emailValidator.isValid(account.getEmail())) {
            errors.rejectValue("email", "Pattern.customerForm.email");
        }
    }
}
