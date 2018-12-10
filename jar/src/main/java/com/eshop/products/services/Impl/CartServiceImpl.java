package com.eshop.products.services.Impl;

import com.eshop.products.dao.CartDAO;
import com.eshop.products.entities.Cart;
import com.eshop.products.entities.Product;
import com.eshop.products.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartDAO cartDAO;

    @Override
    public List<Cart> showAllProductInCart(String login) {
        return cartDAO.getProductsInCart(login);
    }

    @Override
    public void addProductInCart(int productID, String login) {
        cartDAO.addProductInCart(productID, login);
    }

    @Override
    public void removeProductFromCart(int productID, String login) {
        cartDAO.removeProductFromCart(productID,login);
    }
}
