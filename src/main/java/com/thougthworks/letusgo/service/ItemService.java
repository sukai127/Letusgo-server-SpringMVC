package com.thougthworks.letusgo.service;

import com.thougthworks.letusgo.model.Item;

import java.util.List;

/**
 * Created by sukai on 11/12/14.
 */
public interface ItemService {
    List<Item> getItems();

    Item getItem(int id);
}
