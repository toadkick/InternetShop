package com.eshop.products.controllers;
import com.eshop.products.entities.Account;
import com.eshop.products.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

/**
 * UserController  - class-controller for login process and getting user info
 */
@Controller
public class UserController {
    @Autowired
    public UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login() {
        ModelAndView model = new ModelAndView();
        model.setViewName("login");
        return model;
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ModelAndView userInfo() {
        String login = SecurityContextHolder.getContext().getAuthentication().getName();
        Account user = userService.findByLogin(login);
        return new ModelAndView("user", "user", user);
    }
}

