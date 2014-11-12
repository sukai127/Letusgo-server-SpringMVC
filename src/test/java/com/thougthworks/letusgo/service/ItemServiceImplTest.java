package com.thougthworks.letusgo.service;

import com.google.common.collect.ImmutableList;
import com.thougthworks.letusgo.dao.ItemDao;
import com.thougthworks.letusgo.dao.ItemDaoImpl;
import com.thougthworks.letusgo.model.Category;
import com.thougthworks.letusgo.model.Item;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.List;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ItemServiceImplTest {

    private ItemServiceImpl itemService = new ItemServiceImpl();

    @Before
    public void init(){
        ItemDao itemDao = mock(ItemDaoImpl.class);
        ImmutableList<Item> itemList = ImmutableList.of(new Item(1,"ITEM000001","苹果","斤",3.5,new Category(1,"水果")),
                new Item(2,"ITEM000002","可乐","瓶",3.5,new Category(2,"饮料")),
                new Item(3,"ITEM000003","鞋","双",95,new Category(3,"服装")));
        when(itemDao.getItems()).thenReturn(itemList);
        ReflectionTestUtils.setField(itemService,"itemDao",itemDao);
    }

    @Test
    public void should_return_itemList(){

        List<Item> itemList = itemService.getItems();

        assertThat(itemList.size()).isEqualTo(3);
        assertThat(itemList.get(1).getPrice()).isEqualTo(3.5);
        assertThat(itemList.get(2).getCategory().getName()).isEqualTo("服装");
    }
}
