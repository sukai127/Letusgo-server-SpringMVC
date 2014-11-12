package com.thoughtworks.letusgo.service;

import com.thoughtworks.letusgo.dao.ItemDao;
import com.thoughtworks.letusgo.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemDao itemDao;

    @Override
    public List<Item> getItems() {
        return itemDao.getItems();
    }

    @Override
    public Item getItem(int id) {
        return itemDao.getItem(id);
    }

    @Override
    public void insertItem(Item item) {
        itemDao.insertItem(item);
    }

    @Override
    public void deleteItem(int id) {
        itemDao.deleteItem(id);
    }

    @Override
    public void updateItem(Item item) {
        itemDao.updateItem(item);
    }
}
