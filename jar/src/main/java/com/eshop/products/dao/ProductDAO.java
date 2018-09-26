package com.eshop.products.dao;

import com.eshop.products.entities.Category;
import com.eshop.products.entities.Product;

import java.util.List;

public interface ProductDAO {
    List<Product> getAllProducts();
    List<Category> getAllCategories();
    List<Product> getProductsByName(String productName);
    List<Product> getProductsByCategory(int catID);
    Product getProductByID(int id);
}
