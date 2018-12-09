package com.eshop.products.dao.Impl;

import com.eshop.products.dao.UserDAO;
import com.eshop.products.entities.Account;
import com.eshop.products.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
@Repository

public class UserDAOImpl implements UserDAO {
    private JdbcTemplate template;
    @Autowired
    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    @Override
    public void insertUser(String login, String password, String email, String phone) {
        template.update("INSERT INTO SHOP_USERS (login, PASSWORD, PHONE, E_MAIL, ENABLED) VALUES (?,?,?,?,1)", login, password, phone, email);
        template.update("INSERT INTO AUTHORITIES (LOGIN, AUTHORITY) VALUES (?,'USER')", login);
    }

    @Override
    public Account findByLogin(String username) {
        Account account = null;
        try {
            account = (Account) template.queryForObject("select * from SHOP_USERS WHERE LOGIN = " + "'" + username + "'", new UserRowMap());
        } catch (EmptyResultDataAccessException e) {}
        return account;
    }

    class UserRowMap implements RowMapper {

        @Override
        public Object mapRow(ResultSet resultSet, int i) throws SQLException {
            if (resultSet.next()) {
                Account account = new Account();
                account.setLogin(resultSet.getString(1));
                account.setPassword(resultSet.getString(2));
                account.setPhone(resultSet.getString(3));
                account.setEmail(resultSet.getString(4));
                account.setEnabled(resultSet.getInt(5));
                return account;
            }
                return null;

        }
    }
}
