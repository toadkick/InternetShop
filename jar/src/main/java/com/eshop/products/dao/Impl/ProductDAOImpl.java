package com.eshop.products.dao.Impl;

import com.eshop.products.dao.ProductDAO;
import com.eshop.products.entities.Category;
import com.eshop.products.entities.Product;
import com.eshop.products.entities.ProductRowMap;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * ProductDAOImpl class organizes work with database for getting product's info
 */

@Repository
public class ProductDAOImpl implements ProductDAO {
    private static final Logger LOGGER = Logger.getLogger(ProductDAOImpl.class);

    private JdbcTemplate template;
    private static final String GET_3_PROD = "select * from products where rownum < 4";
    private static final String GET_ALL_PROD = "select * from products";
    private static final String GET_ALL_CATEGORY =
            "select category_id, lpad('-', 3*level, '-')||CATEGORY_NAME, parent_category_id from CATEGORY " +
                    "START WITH parent_category_id is null CONNECT BY PRIOR CATEGORY_ID = PARENT_CATEGORY_ID";
    private static final String GET_PROD_BY_NAME = "select * from products where upper(name) LIKE upper('%'||?||'%')";
    private static final String GET_PROD_BY_CATEGORY = "select * from products where CATEGORY_ID = ?";
    private static final String GET_PROD_BY_ID = "select * from products where product_id = ?";
    private static final String GET_CAT_BY_ID = "select * from category where category_id = ?";
    private static final String CHECK_AVAILABLE = "select quantity from products where product_id = ?";
    private static final String GET_ALL_PROD_FOR_ADMIN =
            "select product_id, category_id, lpad('-', 3*level, '-')||NAME, author, parent_id, " +
                    "price, quantity, year_date, imgSource from PRODUCTS " +
                    "START WITH parent_id is null CONNECT BY PRIOR product_id = PARENT_ID";

    @Autowired
    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    /**
     * Method for represent 3 products
     *
     * @return List of 3 products
     */
    @Override
    public List<Product> getTopProducts() {
        return template.query(GET_3_PROD, new ProductRowMap());
    }

    /**
     * Method for represent All products
     *
     * @return List of All products
     */
    @Override
    public List<Product> getAllProducts() {
        return template.query(GET_ALL_PROD, new ProductRowMap());
    }

    /**
     * Method for represent All categories
     *
     * @return List of All categories
     */
    @Override
    public List<Category> getAllCategories() {
        return template.query(GET_ALL_CATEGORY, new CategoryMapper());
    }

    /**
     * Method for represent product's list with searched name
     *
     * @return List of product's with searched name
     */
    @Override
    public List<Product> getProductsByName(String productName) {
        return template.query(GET_PROD_BY_NAME, new Object[] {productName}, new ProductRowMap());
    }

    /**
     * Method for represent products under selected category
     *
     * @param catID Category's ID
     * @return List of product's under category
     */
    @Override
    public List<Product> getProductsByCategory(int catID) {
        return template.query(GET_PROD_BY_CATEGORY, new Object[] {catID}, new ProductRowMap());
    }

    /**
     * Method for represent product by id
     *
     * @param id Product's ID
     * @return Product by ID
     */
    @Override
    public Product getProductByID(int id) {
        return template.query(GET_PROD_BY_ID, new Object[] {id}, new ProductRowMap()).get(0);
    }

    /**
     * Method for represent category by id
     *
     * @param id Category's ID
     * @return Category by ID
     */
    @Override
    public Category getCategoryByID(int id) {
        return template.query(GET_CAT_BY_ID, new Object[] {id}, new CategoryMapper()).get(0);
    }

    /**
     * Method for represent products for admin view
     *
     * @return List of All products
     */
    @Override
    public List<Product> getAllProductsForAdmin() {
        return template.query(GET_ALL_PROD_FOR_ADMIN, new ProductRowMap());
    }

    /**
     * Method for checking available the product
     *
     * @param id Product's ID
     * @return product quantity > 0
     */
    @Override
    public boolean checkAvailable(int id) {
        return template.queryForObject(CHECK_AVAILABLE, new Object[] {id}, Integer.class) > 0;
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
