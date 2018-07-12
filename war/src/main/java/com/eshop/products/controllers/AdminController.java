package com.eshop.products.controllers;
import com.eshop.products.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;

    /*RequestMapping("/addProduct")
    public ModelAndView addProduct*/
}
