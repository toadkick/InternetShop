package com.eshop.products.dao;

import com.eshop.products.entities.Account;

import java.util.List;

public interface UserDAO {

    public List<Account> findByLogin(String login);
}
