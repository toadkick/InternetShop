package com.eshop.products.services;

import com.eshop.products.entities.Product;
import java.util.List;

public interface ProductsService {
    List<Product> showAllProducts();
    List<Product> showAllCategories();
}
