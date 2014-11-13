package com.thoughtworks.letusgo.dao;

import com.thoughtworks.letusgo.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CategoryDaoImpl {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Category> getCategories(){

        List<Category> categories;
        String sql = "select * from category";

        categories = jdbcTemplate.query(sql,new RowMapper<Category>() {
            @Override
            public Category mapRow(ResultSet resultSet, int i) throws SQLException {
                return new Category(resultSet.getInt("id"),resultSet.getString("name"));
            }
        });
        return categories;
    }
}
