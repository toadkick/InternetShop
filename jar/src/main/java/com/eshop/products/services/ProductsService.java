package com.eshop.products.services;

import com.eshop.products.entities.Category;
import com.eshop.products.entities.Product;
import java.util.List;

public interface ProductsService {
    List<Product> showAllProducts();
    List<Product> showTopProducts();
    List<Category> showAllCategories();
    List<Product> getProductsByCategory(int catID);
    Product getProductByID(int id);
    List<Product> getProductsByName(String productName);
    boolean checkAvailable(int id);
}
