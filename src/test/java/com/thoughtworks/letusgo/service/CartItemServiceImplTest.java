package com.thoughtworks.letusgo.service;

import com.google.common.collect.ImmutableList;
import com.thoughtworks.letusgo.dao.CartItemDao;
import com.thoughtworks.letusgo.dao.CartItemDaoImpl;
import com.thoughtworks.letusgo.model.CartItem;
import com.thoughtworks.letusgo.model.Category;
import com.thoughtworks.letusgo.model.Item;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.List;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CartItemServiceImplTest {

    private CartItemService cartItemService = new CartItemServiceImpl();
    private CartItemDao cartItemDao ;
    private ImmutableList<CartItem> cartItems;

    @Before
    public void init(){
        cartItemDao = mock(CartItemDaoImpl.class);
        cartItems = ImmutableList.of(new CartItem(1,new Item(1,"ITEM000001","苹果","斤",3.5,new Category(1,"水果")),3),
                new CartItem(2,new Item(2,"ITEM000002","可乐","瓶",3.5,new Category(2,"饮料")),1),
                new CartItem(3,new Item(3,"ITEM000003","鞋","双",99,new Category(3,"服装")),2));

        when(cartItemDao.getCartItems()).thenReturn(cartItems);

        ReflectionTestUtils.setField(cartItemService,"cartItemDao",cartItemDao);
    }

    @Test
    public void should_return_cartItemList(){

        List<CartItem> cartItemList = cartItemService.getCartItems();

        assertThat(cartItemList.size()).isEqualTo(3);
        assertThat(cartItemList.get(1).getCount()).isEqualTo(1);
        assertThat(cartItemList.get(1).getItem().getName()).isEqualTo("可乐");
        assertThat(cartItemList.get(1).getItem().getCategory().getName()).isEqualTo("饮料");

    }
}
