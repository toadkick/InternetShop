package com.eshop.products.services.Impl;

import com.eshop.products.dao.CartDAO;
import com.eshop.products.dao.ProductDAO;
import com.eshop.products.entities.Cart;
import com.eshop.products.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartDAO cartDAO;

    @Autowired
    private ProductDAO productDAO;

    @Override
    public List<Cart> showAllProductInCart(String login) {
        return cartDAO.getProductsInCart(login);
    }

    @Override
    @Transactional
    public void addProductInCart(int productID, String login) {
        cartDAO.addProductInCart(productID, login);
        cartDAO.updateProd(productID, 1);
    }

    @Override
    @Transactional
    public void removeProductFromCart(int productID, String login) {
        cartDAO.removeProductFromCart(productID, login);
        cartDAO.updateProductCountAfterRemoveFromCart(productID, login);
    }

    @Override
    public void buy(String login) {
        cartDAO.buy(login);
    }

    @Override
    @Transactional
    public void updateCart(String login, int productID, int value) {
        if (value > 0) {
            if (productDAO.checkAvailable(productID)) {
                cartDAO.updateCart(login, productID, value);
                cartDAO.updateProd(productID, value);
            }
        } else {
            cartDAO.updateCart(login, productID, value);
            cartDAO.updateProd(productID, value);
        }
    }
}
