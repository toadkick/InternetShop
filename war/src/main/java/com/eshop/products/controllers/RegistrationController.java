package com.eshop.products.controllers;
import com.eshop.products.entities.Account;
import com.eshop.products.services.UserService;
import com.eshop.products.validator.FormValidator;
import org.apache.log4j.Logger;
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

    private static final Logger LOGGER = Logger.getLogger(RegistrationController.class);

    @Autowired
    UserService userService;

    @Autowired
    FormValidator formValidator;

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
        formValidator.validate(account, result);
        if (result.hasErrors()) {
            return "register";
        }
        userService.insertUser(account.getLogin(), account.getPassword(), account.getEmail(), account.getPhone());
        status.setComplete();
        return "login";
    }
}
