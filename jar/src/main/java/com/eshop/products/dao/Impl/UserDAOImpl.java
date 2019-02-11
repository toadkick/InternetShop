package com.eshop.products.dao.Impl;

import com.eshop.products.dao.UserDAO;
import com.eshop.products.entities.Account;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * UserDAOImpl class organizes work with database for user's features
 */

@Repository
public class UserDAOImpl implements UserDAO {
    private static final Logger LOGGER = Logger.getLogger(UserDAO.class);
    private static final String GET_USER_BY_LOGIN =  "select LOGIN, PHONE, E_MAIL from SHOP_USERS WHERE LOGIN = ?";
    private static final String INSERT_USER_TO_SHOP_USER =
            "INSERT INTO SHOP_USERS (login, PASSWORD, PHONE, E_MAIL, ENABLED) VALUES (?,?,?,?,1)";
    private static final String INSERT_USER_TO_AUTHORITIES =
            "INSERT INTO AUTHORITIES (LOGIN, AUTHORITY) VALUES (?,'USER')";

    private JdbcTemplate template;

    @Autowired
    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    /**
     * Method for inserting new user to database into SHOP_USERS table
     *
     * @param login User's login
     * @param password User's password
     * @param email User's email
     * @param phone User's phone
     */
    @Override
    public void insertUserToShopUser(String login, String password, String email, String phone) {
        LOGGER.debug("Insert new user to database. Login: " + login + ", email: " + email + ", phone: " + phone);
        try {
            template.update(INSERT_USER_TO_SHOP_USER, login, password, phone, email);
        } catch (Exception e) {
            LOGGER.error("Error during inserting new user to database. Login: " + login + ", email: " + email + ", phone: " + phone, e);
        }
    }

    /**
     * Method for inserting new user to database into AUTHORITIES table
     *
     * @param login User's login
     */
    @Override
    public void insertUserToAuthorities(String login) {
        template.update(INSERT_USER_TO_AUTHORITIES, login);
    }

    /**
     * Method for searching user in DB by login
     *
     * @param login User's login
     * @return Account if user was found or null if was not found
     */
    @Override
    public Account findByLogin(String login) {
        Account account = null;
        try {
            account = (Account) template.queryForObject(GET_USER_BY_LOGIN, new Object[] {login}, new UserRowMap());
        } catch (EmptyResultDataAccessException e) {
            LOGGER.error("Error during find user by login: " + login, e);
        }
        return account;
    }

    class UserRowMap implements RowMapper {

        @Override
        public Object mapRow(ResultSet resultSet, int i) throws SQLException {
            Account account = new Account();
            if (resultSet != null) {
                account.setLogin(resultSet.getString(1));
                account.setPhone(resultSet.getString(2));
                account.setEmail(resultSet.getString(3));
            }
                return account;
        }
    }
}
