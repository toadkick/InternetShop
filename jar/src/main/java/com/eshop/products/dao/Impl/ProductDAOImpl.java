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
    private static final String GET_3_PROD = "select * from products where rownum < 4 ORDER BY QUANTITY desc";
    private static final String GET_ALL_PROD = "select * from products";
    private static final String GET_ALL_CATEGORY =
            "select category_id, lpad('-', 3*level, '-')||CATEGORY_NAME, parent_category_id from CATEGORY " +
                    "START WITH parent_category_id is null CONNECT BY PRIOR CATEGORY_ID = PARENT_CATEGORY_ID";
    private static final String GET_PROD_BY_NAME = "select * from products where upper(name) LIKE upper('%'||?||'%')";
    private static final String GET_PROD_BY_CATEGORY = "select * from products where CATEGORY_ID = ?";
    private static final String GET_PROD_BY_ID = "select * from products where product_id = ?";
    private static final String GET_CAT_BY_ID = "select * from category where category_id = ?";
    private static final String CHECH_AVAILABLE = "select quantity from products where product_id = ?";
    private static final String GET_ALL_PROD_FOR_ADMIN =
            "select product_id, category_id, lpad('-', 3*level, '-')||NAME, author, parent_id, " +
                    "price, quantity, year_date, imgSource from PRODUCTS " +
                    "START WITH parent_id is null CONNECT BY PRIOR product_id = PARENT_ID";


    @Autowired
    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    @Override
    public List<Product> getTopProducts() {
        return template.query(GET_3_PROD, new ProductRowMap());
    }

    @Override
    public List<Product> getAllProducts() {
        return template.query(GET_ALL_PROD, new ProductRowMap());
    }

    public List<Category> getAllCategories() {
        return template.query(GET_ALL_CATEGORY, new CategoryMapper());
    }

    @Override
    public List<Product> getProductsByName(String productName) {
        return template.query(GET_PROD_BY_NAME, new Object[] {productName}, new ProductRowMap());
    }

    @Override
    public List<Product> getProductsByCategory(int catID) {
        return template.query(GET_PROD_BY_CATEGORY, new Object[] {catID}, new ProductRowMap());
    }

    @Override
    public Product getProductByID(int id) {
        return template.query(GET_PROD_BY_ID, new Object[] {id}, new ProductRowMap()).get(0);
    }

    @Override
    public Category getCategoryByID(int id) {
        return template.query(GET_CAT_BY_ID, new Object[] {id}, new CategoryMapper()).get(0);
    }

    @Override
    public List<Product> getAllProductsForAdmin() {
        return template.query(GET_ALL_PROD_FOR_ADMIN, new ProductRowMap());
    }

    @Override
    public boolean checkAvailable(int id) {
        return template.queryForObject(CHECH_AVAILABLE, new Object[] {id}, Integer.class) > 0;
    }

    private static final class CategoryMapper implements RowMapper<Category> {

        @Override
        public Category mapRow(ResultSet resultSet, int i) throws SQLException {
            Category category = new Category();
            category.setCategoryID(resultSet.getInt(1));
            category.setName(resultSet.getString(2));
            category.setParentID(resultSet.getInt(3));
            return category;
        }
    }

}
