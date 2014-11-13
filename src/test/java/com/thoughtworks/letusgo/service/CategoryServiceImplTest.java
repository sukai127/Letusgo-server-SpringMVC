package com.thoughtworks.letusgo.service;

import com.google.common.collect.ImmutableList;
import com.thoughtworks.letusgo.dao.CategoryDao;
import com.thoughtworks.letusgo.dao.CategoryDaoImpl;
import com.thoughtworks.letusgo.model.Category;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.List;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CategoryServiceImplTest {

    private CategoryService categoryService = new CategoryServiceImpl();
    private CategoryDao categoryDao ;
    private ImmutableList<Category> categories;

    @Before
    public void init(){
        categoryDao = mock(CategoryDaoImpl.class);
        categories = ImmutableList.of(new Category(1,"饮料"),new Category(2,"水果"),new Category(3,"服装"));
        when(categoryDao.getCategories()).thenReturn(categories);

        when(categoryDao.getCategory(2)).thenReturn(categories.get(1));
        ReflectionTestUtils.setField(categoryService,"categoryDao",categoryDao);
    }

    @Test
    public void should_return_categoryList(){

        List<Category> categoryList = categoryService.getCategories();

        assertThat(categoryList.size()).isEqualTo(3);
        assertThat(categoryList.get(2).getName()).isEqualTo("服装");
    }

    @Test
    public void should_return_category_when_input_id(){

        Category category = categoryService.getCategory();
        assertThat(category.getName()).isEqualTo("水果");
    }
}
