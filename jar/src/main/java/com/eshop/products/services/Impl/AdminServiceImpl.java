package com.eshop.products.services.Impl;

import com.eshop.products.dao.AdminDAO;
import com.eshop.products.dao.ProductDAO;
import com.eshop.products.entities.Product;
import com.eshop.products.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * AdminServiceImpl service class organizes work with DAO for admin's features
 */
@Service
public class AdminServiceImpl implements AdminService {

    private ProductDAO productDAO;
    @Autowired
    public void setProductDAO(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    private AdminDAO adminDAO;
    @Autowired
    public void setAdminDAO(AdminDAO adminDAO) {
        this.adminDAO = adminDAO;
    }

    @Override
    public void addProduct(int catID, String name, String author, int parID, double price, int count, int date, String img) {
        adminDAO.addProduct(catID, name, author, parID, price, count, date, img);
    }

    @Override
    public void editProduct(int id, int catID, String name, String author, int parID, double price, int count, int date, String img) {
        adminDAO.editProduct(id, catID, name, author, parID, price, count, date, img);
    }

    @Override
    public void deleteProduct(int id) {
        adminDAO.deleteProduct(id);
    }

    @Override
    public void addCategory(String name, int parID) {

        adminDAO.addCategory(name, parID);
    }

    @Override
    public void deleteCategory(int id) {
        adminDAO.deleteCategory(id);
    }

    @Override
    public void editCategory(int id, String name, int parID){
        adminDAO.editCategory(id, name, parID);
    }

    @Override
    public List<Product> productsForProdManagment() {
        return productDAO.getAllProductsForAdmin();
    }
}
