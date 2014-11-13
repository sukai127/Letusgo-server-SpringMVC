package com.thoughtworks.letusgo.controller;

import com.thoughtworks.letusgo.model.Category;
import com.thoughtworks.letusgo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoryController {

    @Autowired
    private CategoryService categoryServiceImpl;

    @RequestMapping(value = "/categories" , method = RequestMethod.GET)
    public List<Category> getCategories(){
        return categoryServiceImpl.getCategories();
    }
}
