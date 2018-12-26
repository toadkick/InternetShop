package com.eshop.products.dao;

import com.eshop.products.entities.Account;

import java.util.List;

public interface UserDAO {

    Account findByLogin(String login);
    void insertUserToShopUser(String login, String password, String email, String phone);
    void insertUserToAuthorities(String login);
}
