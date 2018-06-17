package com.eshop.products.services.Impl;


import com.eshop.products.dao.Impl.ProductDAOImpl;
import com.eshop.products.entities.Product;
import com.eshop.products.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductsServiceImpl implements ProductsService {
    @Autowired
    private ProductDAOImpl productDAO;

    private List<Product> productList = new ArrayList<>();

    @RequestMapping("/viewAll")
    public ModelAndView showAllProducts() {
        productList = productDAO.getAllProducts();
        return  new ModelAndView("productList", "list", productList);
    }
}
