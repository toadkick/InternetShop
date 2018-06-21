package com.eshop.products.services.Impl;

import com.eshop.products.dao.Impl.ProductDAOImpl;
import com.eshop.products.dao.ProductDAO;
import com.eshop.products.entities.Product;
import com.eshop.products.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductsServiceImpl implements ProductsService {

    @Autowired
    private ProductDAO productDAO;

    public List<Product> showAllProducts() {
        return productDAO.getAllProducts();
    }
    public List<Product> showAllCategories() {return productDAO.getAllCategories();}
}
