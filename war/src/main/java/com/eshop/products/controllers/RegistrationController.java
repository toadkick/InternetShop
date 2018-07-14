package com.eshop.products.controllers;
import com.eshop.products.entities.Account;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
@RequestMapping(value = "/register")
public class RegistrationController {
    @RequestMapping(method = RequestMethod.GET)
    public String viewRegistration(Map<String, Object> model) {
        Account userForm = new Account();
        model.put("userForm", userForm);
        return "register";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String processRegistration(@ModelAttribute("userForm") @Validated Account account,
                                      Map<String, Object> model) {
        System.out.println("username: " + account.getLogin());
        System.out.println("password: " + account.getPassword());
        System.out.println("email: " + account.getEmail());
        System.out.println("phone: " + account.getPhone());

        return "login";

    }
}
