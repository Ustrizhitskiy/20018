package com.less6.services;

import com.less6.dao.CartDaoImpl;
import com.less6.models.Cart;

import java.util.List;

public class CartService {
    private CartDaoImpl cartDao = new CartDaoImpl();

    public CartService() {
    }

    public void saveCart (Cart cart) {
        cartDao.saveCart(cart);
    }

    public Cart getCartById(int id) {
        return cartDao.getCartById(id);
    }

    public void deleteCart(Cart cart) {
        cartDao.deleteCart(cart.getId());
    }

    public List<Cart> getAll() {
        return cartDao.getAll();
    }

}
