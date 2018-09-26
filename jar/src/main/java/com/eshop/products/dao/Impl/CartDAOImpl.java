package com.eshop.products.dao.Impl;

import com.eshop.products.dao.CartDAO;
import com.eshop.products.entities.Account;
import com.eshop.products.entities.Product;
import com.eshop.products.entities.ProductRowMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CartDAOImpl implements CartDAO {
    private JdbcTemplate template;

    @Autowired
    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    @Override
    public List<Product> getProductsInCart(int cartID) {
        return template.query("select * from PRODUCTS p " +
                        "join CART_PRODUCTS cp on(p.PRODUCT_ID=cp.PRODUCT_ID) where cp.CART_ID="+cartID,
                new ProductRowMap());
    }

    @Override
    public void addProductInCart(int productID, int cartID, int count) {
        template.update("insert INTO CART_PRODUCTS VALUES (cart_product_seq.nextval," + cartID +
                "," + productID + "," + count + ")");
    }

    @Override
    public void removeProductFromCart(int productID, int cartID) {
        template.update("delete from CART_PRODUCTS where CART_ID=" + cartID + " and PRODUCT_ID=" + productID);
    }
}
