package com.thoughtworks.letusgo.service;

import com.thoughtworks.letusgo.model.CartItem;

import java.util.List;

public interface CartItemService {
    List<CartItem> getCartItems();

    CartItem getCartItem(int id);
}
