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

/**
 * CartDAOImpl class organizes work with database for cart's features
 */

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

    /**
     * Method for represent user's cart
     *
     * @param login User's name
     * @return products in the cart
     */
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

    /**
     * Method for adding product to cart
     *
     * @param productID Product's ID
     * @param login User's name
     */
    @Override
    public void addProductInCart(int productID, String login) {
        LOGGER.debug("add product to cart: " + productID + " login " + login);
        try {
            template.update(UPDATE_PROD_IN_CART, login, productID);
        } catch (Exception e) {
            LOGGER.error("Error during add product to cart for login: " + login + " Product:" + productID, e);
        }
    }

    /**
     * Method for updating Product table in database after removing product from cart
     *
     * @param productID Product's ID
     * @param login User's name
     */
    @Override
    public void updateProductCountAfterRemoveFromCart(int productID, String login) {
        LOGGER.debug("updating PRODUCTS table: " + productID + " login " + login);
        try {
            template.update(UPDATE_PROD_COUNT_IN_PRODUCTS_2, login, productID);
        } catch (Exception e) {
            LOGGER.error("ERROR during updating PRODUCTS table: " + login + " Product:" + productID, e);
        }
    }

    /**
     * Method for deleting product from cart
     *
     * @param productID Product's ID
     * @param login User's name
     */
    @Override
    public void removeProductFromCart(int productID, String login) {
        template.update(DELETE_PROD_FROM_CART, login, productID);
    }

    /**
     * Method for updating CART table
     *
     * @param login User's name
     * @param id Product's ID
     * @param value Product's quantity
     */
    @Override
    public void updateCart(String login, int id, int value) {
        LOGGER.debug("updating CART table: " + id + " login " + login + " value " + value);
        try {
            template.update(UPDATE_CART_COUNT_IN_PRODUCTS, value, id, login);
        } catch (Exception e) {
            LOGGER.error("ERROR during updating CART table: " + id + " login " + login + " value " + value, e);
        }

    }

    /**
     * Method for updating PRODUCTS table
     *
     * @param id Product's ID
     * @param value Product's quantity
     */

    @Override
    public void updateProd(int id, int value) {
        LOGGER.debug("updating PRODUCTS table: " + id + " value " + value);
        try {
            template.update(UPDATE_PROD_COUNT_IN_PRODUCTS, value, id);
        } catch (Exception e) {
            LOGGER.error("ERROR during updating PRODUCTS table: " + id + " value " + value, e);
        }
    }

    /**
     * Method for updating CART table after buying
     *
     * @param login User's name
     */
    @Override
    public void buy(String login) {
        LOGGER.debug("deleting products in CART table for login: " + login);
        try {
            template.update(BUY, login);
        } catch (Exception e) {
            LOGGER.error("ERROR during deleting products in CART table for login: " + login, e);
        }
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
