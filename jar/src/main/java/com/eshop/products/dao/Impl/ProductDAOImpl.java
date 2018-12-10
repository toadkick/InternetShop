package com.eshop.products.dao.Impl;

import com.eshop.products.dao.ProductDAO;
import com.eshop.products.entities.Category;
import com.eshop.products.entities.Product;
import com.eshop.products.entities.ProductRowMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductDAOImpl implements ProductDAO {
    private JdbcTemplate template;

    @Autowired
    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    @Override
    public List<Product> getTopProducts() {
        return template.query("select * from products where rownum < 4", new ProductRowMap());
    }

    @Override
    public List<Product> getAllProducts() {
        return template.query("select * from products", new ProductRowMap());
    }

    public List<Category> getAllCategories() {
        return template.query("select * from CATEGORY", new CategoryMapper());
    }

    @Override
    public List<Product> getProductsByName(String productName) {
        return template.query("select * from products where upper(name) LIKE upper(\'%" + productName + "%\')", new ProductRowMap());
    }

    @Override
    public List<Product> getProductsByCategory(int catID) {
        return template.query("select * from products where CATEGORY_ID=" + catID, new ProductRowMap());
    }

    @Override
    public Product getProductByID(int id) {
        return template.query("select * from products where product_id=" + id, new ProductRowMap()).get(0);
    }

    private static final class CategoryMapper implements RowMapper<Category> {

        @Override
        public Category mapRow(ResultSet resultSet, int i) throws SQLException {
            Category category = new Category();
            category.setCategoryID(resultSet.getInt("category_id"));
            category.setName(resultSet.getString("category_name"));
            category.setParentID(resultSet.getInt("parent_category_id"));
            return category;
        }
    }

}
