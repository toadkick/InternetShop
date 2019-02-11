package com.eshop.products.controllers;

import com.eshop.products.entities.Cart;
import com.eshop.products.services.CartService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * CartController  - class-controller for admin and user features regarding cart
 */
@Controller
public class CartController {
    @Autowired
    private CartService cartService;

    @RequestMapping(value = "/cart" , method = RequestMethod.GET)
    public ModelAndView showAllProductInCart() {
        String login = SecurityContextHolder.getContext().getAuthentication().getName();
        List<Cart> cartList = cartService.showAllProductInCart(login);
        return new ModelAndView("cart", "list", cartList);
    }

    @RequestMapping(value = "/deleteFromCart/{id}", method = RequestMethod.GET)
    public ModelAndView deleteProductFromCart(@PathVariable("id") int id) {
        String login = SecurityContextHolder.getContext().getAuthentication().getName();
        cartService.removeProductFromCart(id,login);
        List<Cart> list = cartService.showAllProductInCart(login);
        return new ModelAndView("cart", "list", list);

    }

    @RequestMapping(value = "/addToCart/{id}", method = RequestMethod.GET)
    public String addProductToCart(HttpServletRequest request, @PathVariable("id") int id) {
        String login = SecurityContextHolder.getContext().getAuthentication().getName();
        cartService.addProductInCart(id, login);
        String referer = request.getHeader("Referer");
        return "redirect:"+ referer;
        }

    @RequestMapping(value = "/increase/{id}", method = RequestMethod.GET)
    public String increase(HttpServletRequest request, @PathVariable("id") int id) {
        String login = SecurityContextHolder.getContext().getAuthentication().getName();
        cartService.updateCart(login, id, 1);
        String referer = request.getHeader("Referer");
        return "redirect:"+ referer;
    }

    @RequestMapping(value = "/decrease/{id}", method = RequestMethod.GET)
    public String decrease(HttpServletRequest request, @PathVariable("id") int id) {
        String login = SecurityContextHolder.getContext().getAuthentication().getName();
        cartService.updateCart(login, id, -1);
        String referer = request.getHeader("Referer");
        return "redirect:"+ referer;
    }

    @RequestMapping(value = "/removeFromCart/{id}", method = RequestMethod.GET)
    public String removeFromCart (HttpServletRequest request, @PathVariable("id") int id) {
        String login = SecurityContextHolder.getContext().getAuthentication().getName();
        cartService.removeProductFromCart(id, login);
        String referer = request.getHeader("Referer");
        return "redirect:"+ referer;
    }
    @RequestMapping(value = "/buy", method = RequestMethod.GET)
    public String buy(HttpServletRequest request) {
        String login = SecurityContextHolder.getContext().getAuthentication().getName();
        cartService.buy(login);
        String referer = request.getHeader("Referer");
        return "redirect:"+ referer;
    }
}
