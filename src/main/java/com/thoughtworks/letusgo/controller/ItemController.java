package com.thoughtworks.letusgo.controller;

import com.thoughtworks.letusgo.model.Item;
import com.thoughtworks.letusgo.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ItemController {
    @Autowired
    private ItemService itemServiceImpl;

    @RequestMapping(value = "/items", method = RequestMethod.GET)
    public List<Item> getItems() {
        return itemServiceImpl.getItems();
    }

}
