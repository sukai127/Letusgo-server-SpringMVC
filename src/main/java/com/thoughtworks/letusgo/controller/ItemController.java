package com.thoughtworks.letusgo.controller;

import com.thoughtworks.letusgo.model.Item;
import com.thoughtworks.letusgo.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/items/{id}", method = RequestMethod.GET)
    public Item getItem(@PathVariable int id) {
        return itemServiceImpl.getItem(id);
    }

    @RequestMapping(value = "/items/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteItem(@PathVariable int id) {
        itemServiceImpl.deleteItem(id);
    }

    @RequestMapping(value = "/items", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void insertItem(@RequestBody Item item) {
        itemServiceImpl.insertItem(item);
    }

}
