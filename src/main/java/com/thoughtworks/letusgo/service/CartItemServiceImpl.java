package com.thoughtworks.letusgo.service;

import com.thoughtworks.letusgo.dao.CartItemDao;
import com.thoughtworks.letusgo.model.CartItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartItemServiceImpl {

    @Autowired
    private CartItemDao cartItemDao;

    public List<CartItem> getCartItems() {
        return null;
    }
}
