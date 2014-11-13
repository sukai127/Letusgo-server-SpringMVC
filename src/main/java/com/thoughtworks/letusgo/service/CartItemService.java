package com.thoughtworks.letusgo.service;

import com.thoughtworks.letusgo.model.CartItem;

import java.util.List;

/**
 * Created by sukai on 11/13/14.
 */
public interface CartItemService {
    List<CartItem> getCartItems();
}
