package com.eshop.products.controllers;
import com.eshop.products.entities.Account;
import com.eshop.products.services.UserService;
import com.eshop.products.validator.UserFormValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import java.util.Map;

@Controller
@RequestMapping(value = "/register")
@SessionAttributes("userForm")
public class RegistrationController {
    @Autowired
    UserService userService;

    @Autowired
    UserFormValidator userFormValidator;

    @RequestMapping(method = RequestMethod.GET)
    public String viewRegistration(Map<String, Object> model) {
        Account userForm = new Account();
        model.put("userForm", userForm);
        return "register";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String processRegistration(@ModelAttribute("userForm") @Validated Account account,
                                      BindingResult result, SessionStatus status,
                                      Map<String, Object> model) {
        userFormValidator.validate(account, result);
        if (result.hasErrors()) {
            return "register";
        }
        userService.insertUser(account.getLogin(), account.getPassword(), account.getEmail(), account.getPhone());
        status.setComplete();
        return "login";
    }
}
