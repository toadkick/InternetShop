package com.eshop.products.services.Impl;

import com.eshop.products.dao.Impl.ProductDAOImpl;
import com.eshop.products.dao.ProductDAO;
import com.eshop.products.entities.Category;
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
    public List<Product> showTopProducts() {
        return productDAO.getTopProducts();
    }
    public List<Category> showAllCategories() {return productDAO.getAllCategories();}
    public List<Product> getProductsByCategory(int catID) {return productDAO.getProductsByCategory(catID);}
    public Product getProductByID(int id) {return productDAO.getProductByID(id);}
    public List<Product> getProductsByName(String productName) {return productDAO.getProductsByName(productName);}
}
