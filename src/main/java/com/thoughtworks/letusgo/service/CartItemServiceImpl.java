package com.thoughtworks.letusgo.service;

import com.thoughtworks.letusgo.dao.CartItemDao;
import com.thoughtworks.letusgo.model.CartItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartItemServiceImpl implements CartItemService {

    @Autowired
    private CartItemDao cartItemDao;

    @Override
    public List<CartItem> getCartItems() {
        return cartItemDao.getCartItems();
    }

    @Override
    public CartItem getCartItem(int id) {
        return cartItemDao.getCartItem(id);
    }

    @Override
    public void insertCartItem(CartItem cartItem) {
        cartItemDao.insertCartItem(cartItem);
    }

    @Override
    public void updateCartItem(CartItem cartItem) {
        cartItemDao.updateCartItem(cartItem);
    }

    @Override
    public void deleteCartItem(int id) {
        cartItemDao.deleteCartItem(id);
    }
}
