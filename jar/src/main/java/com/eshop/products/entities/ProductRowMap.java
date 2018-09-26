package com.eshop.products.entities;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductRowMap implements RowMapper<Product> {

    @Override
    public Product mapRow(ResultSet resultSet, int i) throws SQLException {
        Product product = new Product();
        product.setProductID(resultSet.getInt(1));
        product.setCategoryID(resultSet.getInt(2));
        product.setName(resultSet.getString(3));
        product.setAuthor(resultSet.getString(4));
        product.setParentID(resultSet.getInt(5));
        product.setPrice(resultSet.getDouble(6));
        product.setCount(resultSet.getInt(7));
        product.setDate(resultSet.getInt(8));
        product.setImgSource(resultSet.getString(9));
        return product;
    }
}
