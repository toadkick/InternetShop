package com.eshop.products.services.Impl;

import com.eshop.products.dao.CartDAO;
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
    public List<Product> showAllProductInCart(int cartID) {
        return cartDAO.getProductsInCart(cartID);
    }

    @Override
    public void addProductInCart(int productID, int cartID, int count) {
        cartDAO.addProductInCart(productID,cartID,count);
    }

    @Override
    public void removeProductFromCart(int productID, int cartID) {
        cartDAO.removeProductFromCart(productID,cartID);
    }
}
