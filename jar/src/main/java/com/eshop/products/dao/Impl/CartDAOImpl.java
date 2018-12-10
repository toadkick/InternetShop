package com.eshop.products.dao.Impl;

import com.eshop.products.dao.CartDAO;
import com.eshop.products.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
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
    public List<Cart> getProductsInCart(String login) {
        List<Cart> carts = null;
        try {
            carts =  template.query("select c.login login, c.product_id product_id, p.name name, p.price price, c.quantity quantity" +
                    " from PRODUCTS p, CART c " +
                    "WHERE c.PRODUCT_ID = p.PRODUCT_ID and c.login= "+login, new CartMapper());
        } catch (EmptyResultDataAccessException e) {}
        return carts;
    }

    @Override
    public void addProductInCart(int productID, String login) {
        template.update("update PRODUCTS SET quantity = quantity - 1");
        template.update("merge CART t using (SELECT "+login+" as LOGIN, "+productID+" as PRODUCT_ID) v ON " +
                "(t.LOGIN = v.LOGIN and t.PRODUCT_ID = v.PRODUCT_ID) WHEN NOT MATCHED THEN INSERT (LOGIN, PRODUCT_ID, quantity) VALUES (" + login +
                "," + productID + ", 1) WHEN MATCHED THEN UPDATE SET quantity=quantity+1");
    }

    @Override
    public void removeProductFromCart(int productID, String login) {
        template.update("update PRODUCTS SET quantity = quantity + (SELECT quantity FROM CART WHERE LOGIN = "+login+" and product_id = "+ productID+")");
        template.update("delete from CART where Login=" + login + " and PRODUCT_ID=" + productID);
    }

    private static final class CartMapper implements RowMapper<Cart> {

        @Override
        public Cart mapRow(ResultSet resultSet, int i) throws SQLException {
            Cart cart = new Cart();
            cart.setLogin(resultSet.getString("login"));
            cart.setProduct_id(resultSet.getInt("product_id"));
            cart.setProductName(resultSet.getString("name"));
            cart.setPrice(resultSet.getInt("price"));
            cart.setCount(resultSet.getInt("quantity"));
            return cart;
        }
    }
}
