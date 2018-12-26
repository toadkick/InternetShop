package com.eshop.products.dao.Impl;

import com.eshop.products.dao.AdminDAO;
import com.eshop.products.entities.Account;
import com.eshop.products.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Repository
public class AdminDAOImpl implements AdminDAO {

    private static final String ADD_PRODUCT = "insert into PRODUCTS VALUES (NEXT_SEQ.nextval,?,?,?,?,?,?,?,?)";
    private static final String DELETE_PRODUCT = "DELETE FROM PRODUCTS WHERE PRODUCT_ID = ?";
    private static final String DELETE_CATEGORY = "DELETE FROM CATEGORY where CATEGORY_ID = ?";
    private static final String ADD_CATEGORY = "INSERT INTO CATEGORY VALUES(NEXT_SEQ.nextval,?,?)";
    private static final String EDIT_CATEGORY = "UPDATE CATEGORY SET CATEGORY_NAME = ?, PARENT_CATEGORY_ID = ? " +
            "WHERE CATEGORY_ID = ?";
    private static final String EDIT_PRODUCT = "UPDATE PRODUCTS SET category_id = ?, NAME = ?, author = ?, " +
            "parent_id = ?, price = ?, quantity = ?, year_date = ?, imgSource = ?  WHERE PRODUCT_ID = ?";

    private JdbcTemplate template;
    @Autowired
    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    @Override
    public void addProduct(int catID, String name, String author, int parentID, double price, int count, int date, String img) {
        template.update(ADD_PRODUCT, catID, name, author, parentID == 0 ? null : parentID, price, count, date, img);
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

    @Override
    public void editCategory(int id, String name, int parID) {
        template.update(EDIT_CATEGORY, name, parID == 0 ? null : parID, id);
    }

    @Override
    public void editProduct(int id, int catID, String name, String author, int parID, double price, int count, int date, String img) {
        template.update(EDIT_PRODUCT, catID, name, author, parID == 0 ? null : parID, price, count, date, img, id);

    }
}
