package com.eshop.products.dao.Impl;

import com.eshop.products.dao.CartDAO;
import com.eshop.products.entities.Account;
import com.eshop.products.entities.Product;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CartDAOImpl implements CartDAO {
    private JdbcTemplate template;

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    @Override
    public List<Product> getProductsInCart(int cartID) {
        return template.query("select * from PRODUCTS p " +
                        "join CART_PRODUCTS cp on(p.PRODUCT_ID=cp.PRODUCT_ID) where cp.CART_ID="+cartID,
                new CartRowMap());
    }

    private class CartRowMap implements RowMapper<Product> {
        @Override
        public Product mapRow(ResultSet resultSet, int i) throws SQLException {
            Product products = new Product();
            products.setProductID(resultSet.getInt(1));
            products.setCategoryID(resultSet.getInt(2));
            products.setName(resultSet.getString(3));
            products.setAuthor(resultSet.getString(4));
            products.setParentID(resultSet.getInt(5));
            products.setPrice(resultSet.getDouble(6));
            products.setCount(resultSet.getInt(7));
            products.setDate(resultSet.getInt(8));
            return products;
        }
    }
}
