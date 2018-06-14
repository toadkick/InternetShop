package com.eshop.products.dao.Impl;

import com.eshop.products.dao.ProductDAO;
import com.eshop.products.entities.Product;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ProductDAOImpl implements ProductDAO {
    private JdbcTemplate template;

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    @Override
    public List<Product> getAllProducts() {
        return template.query("select * from products", new ProductRowMap());
    }

    @Override
    public List<Product> getProductsByName(String productName) {
        return template.query("select * from products where name is LIKE \"%" + productName + "%\"", new ProductRowMap());
    }

    @Override
    public List<Product> getProductsByCategory(int catID) {
        return template.query("select * from products where CATEGORY_ID=" + catID, new ProductRowMap());
    }

    class ProductRowMap implements RowMapper<Product> {

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
            products.setDate(resultSet.getDate(8));
            return products;
        }
    }
}
