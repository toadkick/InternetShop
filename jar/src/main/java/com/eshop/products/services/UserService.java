package com.eshop.products.services;

import com.eshop.products.entities.Account;

public interface UserService {
    public void insertUser(String login, String password, String email, String phone);
    public Account findByLogin(String login);
}
