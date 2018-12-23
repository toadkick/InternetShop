package com.eshop.products.services.Impl;

import com.eshop.products.dao.AdminDAO;
import com.eshop.products.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDAO adminDAO;

    @Override
    public void addProduct(int catID, String name, String author, int parID, double price, int count, int date) {
        adminDAO.addProduct(catID, name, author, parID, price, count, date);
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
}
