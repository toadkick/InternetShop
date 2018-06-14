package com.eshop.products.dao;

import com.eshop.products.entities.Product;

import java.util.List;

public interface CartDAO {
    List<Product> getProductsInCart(int cartID);
}
