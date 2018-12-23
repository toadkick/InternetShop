package com.eshop.products.services;

import com.eshop.products.entities.Cart;
import com.eshop.products.entities.Product;

import java.util.List;

public interface CartService {
    List<Cart> showAllProductInCart(String login);
    void addProductInCart(int productID, String login);
    void removeProductFromCart(int productID, String login);
    void updateCart(String login, int productID, int value);
    void buy(String login);
}
