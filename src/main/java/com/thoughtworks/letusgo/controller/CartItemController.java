package com.thoughtworks.letusgo.controller;

import com.thoughtworks.letusgo.model.CartItem;
import com.thoughtworks.letusgo.model.Item;
import com.thoughtworks.letusgo.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CartItemController {
    @Autowired
    private CartItemService cartItemService;

    @RequestMapping(value = "/cartItems" ,method = RequestMethod.GET)
    public List<CartItem> getCartItems(){
        return cartItemService.getCartItems();
    }

    @RequestMapping(value = "/cartItems/{id}", method = RequestMethod.GET)
    public CartItem getCartItem(@PathVariable int id) {
        return cartItemService.getCartItem(id);
    }

}
