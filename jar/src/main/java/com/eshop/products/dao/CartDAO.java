package com.eshop.products.dao;

import com.eshop.products.entities.Cart;
import com.eshop.products.entities.Product;

import java.util.List;

public interface CartDAO {
    List<Cart> getProductsInCart(String login);
    void addProductInCart(int productID, String login);
    void removeProductFromCart(int productID, String login);
    void updateCart(String login, int id, int value);
    void updateProd(int id, int value);
    void buy(String login);
    void updateProductCountAfterRemoveFromCart(int productID, String login);
}
