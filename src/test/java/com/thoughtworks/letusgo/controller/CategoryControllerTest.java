package com.thoughtworks.letusgo.controller;

import com.google.common.collect.ImmutableList;
import com.thoughtworks.letusgo.model.Category;
import com.thoughtworks.letusgo.model.Item;
import com.thoughtworks.letusgo.service.CategoryService;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/mvc-dispatcher-servlet.xml"})
@WebAppConfiguration
public class CategoryControllerTest {
    private MockMvc mockMvc;
    private ImmutableList<Category> categoryList;

    @Mock
    private CategoryService categoryService;

    @InjectMocks
    private CategoryController categoryController;

    @Before
    public void init(){

        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(categoryController).build();

        categoryList = ImmutableList.of(
                new Category(1,"水果"),
                new Category(2,"饮料"),
                new Category(3,"服装")
        );
        
        when(categoryService.getCategories()).thenReturn(categoryList);
        when(categoryService.getCategory(1)).thenReturn(categoryList.get(0));
    }
}
