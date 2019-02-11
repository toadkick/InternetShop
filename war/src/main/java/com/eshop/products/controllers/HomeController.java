package com.eshop.products.controllers;

import com.eshop.products.entities.Product;
import com.eshop.products.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * HomeController  - class-controller for home page
 */
@Controller
public class HomeController {

    @Autowired
    private ProductsService productsService;

    @RequestMapping("/home")
    public ModelAndView showAllProducts() {
        List<Product> productList = productsService.showTopProducts();
        return new ModelAndView("home", "list", productList);
    }
}
