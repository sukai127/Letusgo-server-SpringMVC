package com.thougthworks.letusgo.service;

import com.thougthworks.letusgo.dao.ItemDaoImpl;
import com.thougthworks.letusgo.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl {

    @Autowired
    private ItemDaoImpl itemDao;

    public List<Item> getItems() {
        return null;
    }
}
