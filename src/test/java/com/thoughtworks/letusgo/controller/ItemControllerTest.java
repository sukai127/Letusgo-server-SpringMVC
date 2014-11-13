package com.thoughtworks.letusgo.controller;

import com.google.common.collect.ImmutableList;
import com.thoughtworks.letusgo.model.Category;
import com.thoughtworks.letusgo.model.Item;
import com.thoughtworks.letusgo.service.ItemService;
import com.thoughtworks.letusgo.service.ItemServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
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

    private ItemService itemService;

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    protected WebApplicationContext wac;

    @Before
    public void init(){
        itemService = mock(ItemServiceImpl.class);
        mockMvc = webAppContextSetup(this.wac).build();
        itemList = ImmutableList.of(new Item(1, "ITEM000001", "苹果", "斤", 3.5, new Category(1, "水果")),
                new Item(2, "ITEM000002", "可乐", "瓶", 3.5, new Category(2, "饮料")),
                new Item(3, "ITEM000003", "鞋", "双", 95, new Category(3, "服装")));
        when(itemService.getItems()).thenReturn(itemList);
    }

    @Test
    public void should_return_itemList() throws Exception {
        mockMvc.perform(get("/items"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name",is("苹果")));
    }
}
