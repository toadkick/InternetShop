package com.eshop.products.entities;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductRowMap implements RowMapper<Product> {

    @Override
    public Product mapRow(ResultSet resultSet, int i) throws SQLException {
        Product products = new Product();
        products.setProductID(resultSet.getInt(1));
        products.setCategoryID(resultSet.getInt(2));
        products.setName(resultSet.getString(3));
        products.setAuthor(resultSet.getString(4));
        products.setParentID(resultSet.getInt(5));
        products.setPrice(resultSet.getDouble(6));
        products.setCount(resultSet.getInt(7));
        products.setDate(resultSet.getInt(8));
        return products;
    }
}
