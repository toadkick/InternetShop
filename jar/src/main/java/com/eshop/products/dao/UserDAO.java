package com.eshop.products.dao;

import com.eshop.products.entities.Account;

import java.util.List;

public interface UserDAO {

    public Account findByLogin(String login);
    public void insertUser(String login, String password, String email, String phone);
}
