package com.eshop.products.controllers;

import com.eshop.products.entities.Product;
import com.eshop.products.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductsService productsService;

/*    @RequestMapping("/AllProductList")
    public ModelAndView showAllProducts() {
        List<Product> productList = productsService.showAllProducts();
        return new ModelAndView("productList", "list", productList);
    }*/

    @RequestMapping("/productList")
    public String showAllProducts(Model model) {
        List<Product> pl = productsService.showAllProducts();
        model.addAttribute("list", pl);
        return "productList";
    }

    @RequestMapping("/category")
    public String showAllCategories(Model model) {
        List<Product> categoryList = productsService.showAllCategories();
        model.addAttribute("list", categoryList);
        return "category";
    }

/*    @RequestMapping("/category")
    public ModelAndView showAllCategories() {
        List<Product> categoryList = productsService.showAllCategories();
        return new ModelAndView("category", "list", categoryList);
    }*/
}
