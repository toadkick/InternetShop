package com.eshop.products.services.Impl;

import com.eshop.products.dao.UserDAO;
import com.eshop.products.entities.Account;
import com.eshop.products.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * UserServiceImpl class organizes work with DAO class for user's features
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDAO userDAO;

    /**
     * Method for callin DAO-methods for inserting new user to database into SHOP_USERS table and AUTHORITIES table
     *
     * @param login User's login
     * @param password User's password
     * @param email User's email
     * @param phone User's phone
     */
    @Override
    @Transactional
    public void insertUser(String login, String password, String email, String phone) {
        if (userDAO.findByLogin(login) == null)
        {
            userDAO.insertUserToShopUser(login, password, email, phone);
            userDAO.insertUserToAuthorities(login);
        }
    }

    /**
     * Method for calling DAO-methods for searching user in DB by login
     *
     * @param login User's login
     * @return Account if user was found or null if was not found
     */
    @Override
    public Account findByLogin(String login) {
        return userDAO.findByLogin(login);
    }
}
