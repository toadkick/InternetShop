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

    @Override
    public void insertUserToShopUser(String login, String password, String email, String phone) {
        template.update(INSERT_USER_TO_SHOP_USER, login, password, phone, email);
    }
    @Override
    public void insertUserToAuthorities(String login) {
        template.update(INSERT_USER_TO_AUTHORITIES, login);
    }

    @Override
    public Account findByLogin(String username) {
        Account account = null;
        try {
            account = (Account) template.queryForObject(GET_USER_BY_LOGIN, new Object[] {username}, new UserRowMap());
        } catch (EmptyResultDataAccessException e) {}
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
