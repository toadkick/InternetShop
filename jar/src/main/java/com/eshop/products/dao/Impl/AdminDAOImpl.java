package com.eshop.products.dao.Impl;

import com.eshop.products.dao.AdminDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AdminDAOImpl implements AdminDAO {

    private static final String ADD_PRODUCT = "insert into PRODUCTS VALUES (NEXT_SEQ.nextval,?,?,?,?,?,?,?,'2.jpg')";
    private static final String DELETE_PRODUCT = "DELETE FROM PRODUCTS WHERE PRODUCT_ID = ?";
    private static final String DELETE_CATEGORY = "DELETE FROM CATEGORY where CATEGORY_ID = ?";
    private static final String ADD_CATEGORY = "INSERT INTO CATEGORY VALUES(NEXT_SEQ.nextval,?,?)";

    private JdbcTemplate template;
    @Autowired
    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    @Override
    public void addProduct(int catID, String name, String author, int parentID, double price, int count, int date) {
        template.update(ADD_PRODUCT, catID, name, author, parentID, price, count, date);
    }

    @Override
    public void deleteProduct(int id) {
        template.update(DELETE_PRODUCT, id);
    }

    @Override
    public void addCategory(String name, int parentID) {

        template.update(ADD_CATEGORY, name, parentID == 0 ? null : parentID);
    }

    @Override
    public void deleteCategory(int id) {
        template.update(DELETE_CATEGORY, id);
    }
}
