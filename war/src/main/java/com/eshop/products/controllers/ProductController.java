package com.eshop.products.controllers;

import com.eshop.products.entities.Product;
import com.eshop.products.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductsService productsService;

    @RequestMapping("/AllProductList")
    public ModelAndView showAllProducts() {
        List<Product> productList = productsService.showAllProducts();
        return new ModelAndView("productList", "list", productList);
    }

    @RequestMapping("/category")
    public ModelAndView showAllCategories() {
        List<Product> categoryList = productsService.showAllCategories();
        return new ModelAndView("category", "list", categoryList);
    }

    @RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
    public ModelAndView productById(@PathVariable("id") int id) {
        //Product product = productsService.showProduct(id);
        Product product = new Product();
        return new ModelAndView("product", "product", product);
    }

}
