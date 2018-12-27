package com.eshop.products.dao.Impl;

import com.eshop.products.dao.CartDAO;
import com.eshop.products.entities.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CartDAOImpl implements CartDAO {
    private static final Logger LOGGER = Logger.getLogger(CartDAOImpl.class);

    private JdbcTemplate template;
    private static final String UPDATE_PROD_IN_CART =
            "MERGE INTO CART t using (SELECT ? as LOGIN, ? as PRODUCT_ID from dual) v " +
            "ON (t.LOGIN = v.LOGIN and t.PRODUCT_ID = v.PRODUCT_ID)" +
            "WHEN NOT MATCHED THEN INSERT (LOGIN, PRODUCT_ID, quantity) VALUES (v.LOGIN,  v.PRODUCT_ID, 1) " +
            "WHEN MATCHED THEN UPDATE SET quantity=quantity + 1";
    private static final String UPDATE_PROD_COUNT_IN_PRODUCTS =
            "update PRODUCTS SET quantity = quantity - ? WHERE PRODUCT_ID = ?";
    private static final String UPDATE_CART_COUNT_IN_PRODUCTS =
            "update CART SET quantity = quantity + ? WHERE PRODUCT_ID = ? and login = ?";
    private static final String UPDATE_PROD_COUNT_IN_PRODUCTS_2 =
            "update PRODUCTS SET quantity = quantity + (SELECT quantity FROM CART WHERE LOGIN = ? and product_id = ?)";
    private static final String DELETE_PROD_FROM_CART = "delete from CART where login = ? and PRODUCT_ID= ?";
    private static final String GET_CART = "select c.login login, c.product_id product_id, p.name name, p.price price," +
            "c.quantity quantity from PRODUCTS p, CART c WHERE c.PRODUCT_ID = p.PRODUCT_ID and c.login= ?";
    private static final String BUY = "delete from CART where login = ?";

    @Autowired
    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    @Override
    public List<Cart> getProductsInCart(String login) {
        List<Cart> carts = null;
        try {
            carts =  template.query(GET_CART, new Object[] {login}, new CartMapper());
        } catch (EmptyResultDataAccessException e) {
            LOGGER.error("Error during get products from cart for login: " + login, e);
        } catch (Exception e) {
            LOGGER.error("Error during get products from cart for login: " + login, e);
        }
        return carts;
    }

    @Override
    public void addProductInCart(int productID, String login) {
        template.update(UPDATE_PROD_IN_CART, login, productID);
    }

    @Override
    public void updateProductCountAfterRemoveFromCart(int productID, String login) {
        template.update(UPDATE_PROD_COUNT_IN_PRODUCTS_2, login, productID);
    }

    @Override
    public void removeProductFromCart(int productID, String login) {
        template.update(DELETE_PROD_FROM_CART, login, productID);
    }

    @Override
    public void updateCart(String login, int id, int value) {
        template.update(UPDATE_CART_COUNT_IN_PRODUCTS, value, id, login);
    }

    @Override
    public void updateProd(int id, int value) {
        template.update(UPDATE_PROD_COUNT_IN_PRODUCTS, value, id);
    }

    @Override
    public void buy(String login) {
        template.update(BUY, login);
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
