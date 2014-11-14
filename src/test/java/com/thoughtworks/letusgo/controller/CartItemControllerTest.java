package com.thoughtworks.letusgo.controller;


import com.google.common.collect.ImmutableList;
import com.thoughtworks.letusgo.model.CartItem;
import com.thoughtworks.letusgo.model.Category;
import com.thoughtworks.letusgo.model.Item;
import com.thoughtworks.letusgo.service.CartItemService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/mvc-dispatcher-servlet.xml"})
@WebAppConfiguration
public class CartItemControllerTest {
    private MockMvc mockMvc;
    private ImmutableList<CartItem> cartItemList;
    private ImmutableList<Item> itemList;

    @Mock
    private CartItemService cartItemService;

    @InjectMocks
    private CartItemController cartItemController;

    @Before
    public void init(){

        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(cartItemController).build();

        itemList = ImmutableList.of(
                new Item(1, "ITEM000001", "苹果", "斤", 3.5, new Category(1, "水果")),
                new Item(2, "ITEM000002", "可乐", "瓶", 3.5, new Category(2, "饮料")),
                new Item(3, "ITEM000003", "鞋", "双", 95, new Category(3, "服装"))
        );

        cartItemList = ImmutableList.of(
                new CartItem(1,itemList.get(0),10),
                new CartItem(2,itemList.get(1),5),
                new CartItem(3,itemList.get(2),1)
        );

        when(cartItemService.getCartItems()).thenReturn(cartItemList);
        when(cartItemService.getCartItem(1)).thenReturn(cartItemList.get(0));
    }

    @Test
    public void should_return_cartItemList() throws Exception {
        mockMvc.perform(get("/api/cartItems"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$",hasSize(3)))
                .andExpect(jsonPath("$[0].count", is(10)));
    }

    @Test
    public void should_return_cartItem_when_input_id() throws Exception {
        mockMvc.perform(get("/api/cartItems/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.count",is(10)));

    }

}
