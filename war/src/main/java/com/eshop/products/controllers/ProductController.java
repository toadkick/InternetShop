package com.eshop.products.controllers;

import com.eshop.products.entities.Category;
import com.eshop.products.entities.Product;
import com.eshop.products.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
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
        List<Category> categoryList = productsService.showAllCategories();
        return new ModelAndView("category", "list", categoryList);
    }

    @RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
    public ModelAndView productById(@PathVariable("id") int id) {
        Product product = productsService.getProductByID(id);
        return new ModelAndView("product", "product", product);
    }

    @RequestMapping(value = "/category/{id}", method = RequestMethod.GET)
    public ModelAndView productByCat(@PathVariable("id") int id) {
        List<Product> productList = productsService.getProductsByCategory(id);
        return new ModelAndView("productList", "list", productList);
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public ModelAndView search(HttpServletRequest request) {
        List<Product> productList = productsService.getProductsByName(request.getParameter("searchVal"));
        return new ModelAndView("productList", "list", productList);
    }
}
