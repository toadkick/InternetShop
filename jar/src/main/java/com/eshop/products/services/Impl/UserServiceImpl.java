package com.eshop.products.services.Impl;

import com.eshop.products.dao.UserDAO;
import com.eshop.products.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDAO userDAO;

    @Override
    public void insertUser(String login, String password, String email, String phone) {
        if (userDAO.findByLogin(login) == null)
        {
            userDAO.insertUser(login, password, email, phone);
        }
    }
}
