package com.less6.dao;

import com.less6.models.Cart;

import java.io.Serializable;
import java.util.List;

public interface CartDao {

    Serializable saveCart(Cart cart);

    Cart getCartById(int id);

    void deleteCart(int id);

    List<Cart> getAll();
}
