package com.eshop.products.controllers;

import com.eshop.products.entities.Product;
import com.eshop.products.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CartController {

    @Autowired
    private CartService cartService;

    @RequestMapping("/cart")
    public ModelAndView showAllProductInCart(int cartID) {
        List<Product> productList = cartService.showAllProductInCart(cartID);
        return new ModelAndView("cart", "list", productList);
    }

    @RequestMapping("/deleteFromCart")
    public ModelAndView deleteProductFromCart(int cartID,int productID) {
        cartService.removeProductFromCart(productID,cartID);
        List<Product> productList = cartService.showAllProductInCart(cartID);
        return new ModelAndView("cart", "list", productList);
    }

    //TODO adding products
}
