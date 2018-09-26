package com.eshop.products.controllers;

import com.eshop.products.entities.Product;
import com.eshop.products.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

//TODO its need to look


@Controller
public class CartController {

    @Autowired
    private CartService cartService;

    @RequestMapping("/cart")
    public ModelAndView showAllProductInCart(int cartID) {
        List<Product> productList = cartService.showAllProductInCart(cartID);
        return new ModelAndView("cart", "list", productList);
    }

    @RequestMapping("/deleteFromCart/{id}/{cartID}")
    public ModelAndView deleteProductFromCart(@PathVariable("cartID") int cartID,@PathVariable("id") int productID) {
        cartService.removeProductFromCart(productID,cartID);
        List<Product> productList = cartService.showAllProductInCart(cartID);
        return new ModelAndView("cart", "list", productList);
    }

    @RequestMapping("/addToCart")
    public ModelAndView addProductToCart(@RequestParam("cartID")int cartID,@RequestParam("id")int productID,
                                         @RequestParam("count")int count) {
        cartService.addProductInCart(productID,cartID,count);
        List<Product> productList = cartService.showAllProductInCart(cartID);
        return new ModelAndView("cart", "list", productList);
    }
}
