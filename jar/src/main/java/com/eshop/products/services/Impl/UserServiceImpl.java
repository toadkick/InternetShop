package com.eshop.products.services.Impl;

import com.eshop.products.dao.UserDAO;
import com.eshop.products.entities.Account;
import com.eshop.products.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDAO userDAO;

    @Override
    @Transactional
    public void insertUser(String login, String password, String email, String phone) {
        if (userDAO.findByLogin(login) == null)
        {
            userDAO.insertUserToShopUser(login, password, email, phone);
            userDAO.insertUserToAuthorities(login);
        }
    }

    @Override
    public Account findByLogin(String login) {
        return userDAO.findByLogin(login);
    }
}
