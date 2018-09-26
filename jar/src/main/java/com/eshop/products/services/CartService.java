package com.eshop.products.services;

import com.eshop.products.entities.Product;

import java.util.List;

public interface CartService {
    List<Product> showAllProductInCart(int cartID);
    void addProductInCart(int productID, int cartID, int count);
    void removeProductFromCart(int productID, int cartID);
}
