package com.eshop.products.dao.Impl;

import com.eshop.products.dao.UserDAO;
import com.eshop.products.entities.Account;
import com.eshop.products.entities.Product;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDAOImpl implements UserDAO {
    private JdbcTemplate template;

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }
    @Override
    public List<Account> findByLogin(String username) {
        return template.query("select * from SHOP_USERS", new UserRowMap());
    }

    class UserRowMap implements RowMapper<Account> {

        @Override
        public Account mapRow(ResultSet resultSet, int i) throws SQLException {
            Account accounts = new Account();
            accounts.setLogin(resultSet.getString(1));
            accounts.setPassword(resultSet.getString(2));
            accounts.setPhone(resultSet.getString(3));
            accounts.setEmail(resultSet.getString(4));
            if(!"admin".equals(accounts.getLogin())){
                accounts.setRole(Account.ROLE_USER);
            } else {
                accounts.setRole(Account.ROLE_ADMIN);
            }
            return accounts;
        }
    }
}
