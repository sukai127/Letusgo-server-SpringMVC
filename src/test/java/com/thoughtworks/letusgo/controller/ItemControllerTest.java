package com.thoughtworks.letusgo.controller;

import com.google.common.collect.ImmutableList;
import com.thoughtworks.letusgo.model.Category;
import com.thoughtworks.letusgo.model.Item;
import com.thoughtworks.letusgo.service.ItemService;
import com.thoughtworks.letusgo.service.ItemServiceImpl;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/mvc-dispatcher-servlet.xml"})
@WebAppConfiguration
public class ItemControllerTest {

    private MockMvc mockMvc;
    private ImmutableList<Item> itemList;

    @Mock
    private ItemService itemService;

    @InjectMocks
    private ItemController itemController;

    @Before
    public void init(){

        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(itemController).build();

        itemList = ImmutableList.of(new Item(1, "ITEM000001", "苹果", "斤", 3.5, new Category(1, "水果")),
                new Item(2, "ITEM000002", "可乐", "瓶", 3.5, new Category(2, "饮料")),
                new Item(3, "ITEM000003", "鞋", "双", 95, new Category(3, "服装")));
        when(itemService.getItems()).thenReturn(itemList);
        when(itemService.getItem(1)).thenReturn(itemList.get(0));
    }

    @Test
    public void should_return_itemList() throws Exception {
        mockMvc.perform(get("/api/items"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$",hasSize(3)))
                .andExpect(jsonPath("$[0].name", is("苹果")));
    }

    @Test
    public void should_return_item_when_input_id() throws Exception {
        mockMvc.perform(get("/api/items/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is("苹果")));
    }

    @Test
    public void should_delete_item_when_input_id() throws Exception {
        mockMvc.perform(delete("/api/items/1"))
                .andExpect(status().isOk());
        verify(itemService, times(1)).deleteItem(1);
    }
}
