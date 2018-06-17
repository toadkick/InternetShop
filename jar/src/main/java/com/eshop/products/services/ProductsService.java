package com.eshop.products.services;

import org.springframework.web.servlet.ModelAndView;

public interface ProductsService {
    ModelAndView showAllProducts();
    ModelAndView showProductsByCategory();
    ModelAndView showProductsByName();
}
