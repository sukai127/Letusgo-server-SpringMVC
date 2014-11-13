package com.thoughtworks.letusgo.service;

import com.thoughtworks.letusgo.dao.CategoryDao;
import com.thoughtworks.letusgo.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryDao categoryDao;

    @Override
    public List<Category> getCategories() {
        return null;
    }
}
