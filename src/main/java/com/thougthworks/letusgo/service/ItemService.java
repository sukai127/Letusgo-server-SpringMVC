package com.thougthworks.letusgo.service;

import com.thougthworks.letusgo.model.Item;

import java.util.List;

public interface ItemService {
    List<Item> getItems();

    Item getItem(int id);

    void insertItem(Item item);

    void deleteItem(int id);

    void updateItem(Item item);
}
