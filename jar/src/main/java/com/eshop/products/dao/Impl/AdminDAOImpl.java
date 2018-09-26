package com.eshop.products.dao.Impl;

import com.eshop.products.dao.AdminDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AdminDAOImpl implements AdminDAO {

    private JdbcTemplate template;

    @Autowired
    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }


    @Override
    public void addProduct(int id, int catID, String name, String author, int parID, double price, int count, int date) {
        template.update("insert into PRODUCTS VALUES (" + id + "," + catID + "," + name + "," + author + "," +
                parID +"," + price + "," + count + "," + date + ")"
        );
    }

    @Override
    public void deleteProduct(int id) {
        template.update("DELETE FROM PRODUCTS WHERE PRODUCT_ID = " + id);
    }

    @Override
    public void addCategory(int id, String name, int parID) {
        template.update("INSERT INTO CATEGORY VALUES (" + id + "," + name + "," + parID + ")");
    }

    @Override
    public void deleteCategory(int id) {
        template.update("DELETE from CATEGORY where CATEGORY_ID = " + id);
    }
}
