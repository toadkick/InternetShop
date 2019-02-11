package com.eshop.products.validator;

import com.eshop.products.entities.Account;
import com.eshop.products.entities.Category;
import com.eshop.products.entities.Product;
import com.eshop.products.services.UserService;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * FormValidator  - class for validating filled fields
 */
public class FormValidator implements Validator{
    @Autowired
    UserService userService;

    public boolean supports(Class<?> clazz) {
        return Account.class.isAssignableFrom(clazz);
    }

    private EmailValidator emailValidator = EmailValidator.getInstance();

    /**
     * Method for validating registration form
     *
     * @param target Account
     * @param errors Errors
     */
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

    /**
     * Method for validating product's info form
     *
     * @param product Product
     * @param errors Errors
     */
    public void validateProduct(Product product, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty.productForm.name");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "price", "NotEmpty.productForm.price");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "count", "NotEmpty.productForm.quantity");
    }

    /**
     * Method for validating category's info form
     *
     * @param category Category
     * @param errors Errors
     */
    public void validateCategory(Category category, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty.registerForm.login");
        if (category.getName().length() > 20) {
            errors.rejectValue("login", "Pattern.categoryForm.name");
        }

    }
}
