package com.thoughtworks.letusgo.dao;

import com.thoughtworks.letusgo.model.CartItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CartItemDaoImpl {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<CartItem> getCartItems(){

        List<CartItem> cartItems = null;
        String sql = "select * from cartitem";
        cartItems = jdbcTemplate.query(sql,new RowMapper<CartItem>() {
            @Override
            public CartItem mapRow(ResultSet resultSet, int i) throws SQLException {
                return new CartItem(resultSet.getInt("id"),null,resultSet.getInt("count"));
            }
        });
        return cartItems;
    }
}
