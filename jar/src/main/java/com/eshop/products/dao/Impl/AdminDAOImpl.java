package com.eshop.products.dao.Impl;

import com.eshop.products.dao.AdminDAO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * AdminDAOImpl class organizes work with database for admin's features
 */

@Repository
public class AdminDAOImpl implements AdminDAO {
    private static final Logger LOGGER = Logger.getLogger(AdminDAO.class);
    private static final String ADD_PRODUCT = "insert into PRODUCTS VALUES (NEXT_SEQ.nextval,?,?,?,?,?,?,?,?)";
    private static final String DELETE_PRODUCT = "DELETE FROM PRODUCTS WHERE PRODUCT_ID = ?";
    private static final String DELETE_CATEGORY = "DELETE FROM CATEGORY where CATEGORY_ID = ?";
    private static final String ADD_CATEGORY = "INSERT INTO CATEGORY VALUES(NEXT_SEQ.nextval,?,?)";
    private static final String EDIT_CATEGORY = "UPDATE CATEGORY SET CATEGORY_NAME = ?, PARENT_CATEGORY_ID = ? " +
            "WHERE CATEGORY_ID = ?";
    private static final String EDIT_PRODUCT = "UPDATE PRODUCTS SET category_id = ?, NAME = ?, author = ?, " +
            "parent_id = ?, price = ?, quantity = ?, year_date = ?, imgSource = ?  WHERE PRODUCT_ID = ?";

    private JdbcTemplate template;
    @Autowired
    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    /**
     * Method for adding product to database
     *
     * @param catID Category's ID
     * @param name Product name
     * @param author Name of the author
     * @param parentID Parent's ID
     * @param price Product's price
     * @param count Quantity
     * @param date Date of creation
     * @param img Image's name
     */
    @Override
    public void addProduct(int catID, String name, String author, int parentID, double price, int count, int date, String img) {
        LOGGER.debug("add product values: " + name + ", " + catID + ", " + author + ", " + (parentID == 0 ? null : parentID)
                + ", " + price + ", " + count + ", " + date + ", " + img);
        try {
            template.update(ADD_PRODUCT, catID, name, author, parentID == 0 ? null : parentID, price, count, date, img);
        } catch (Exception e) {
            LOGGER.error("error during add product, values: " + name + ", " + catID + ", " + author + ", " +
                    (parentID == 0 ? null : parentID) + ", " + price + ", " + count + ", " + date + ", " + img, e);
        }
    }

    /**
     * Method for deleting product from database
     *
     * @param id Product's ID
     */
    @Override
    public void deleteProduct(int id) {
        LOGGER.debug("delete product  with id:" + id);
        try {
            template.update(DELETE_PRODUCT, id);
        } catch (Exception e) {
            LOGGER.error("error during deleting product, id: " + id, e);
        }
    }

    /**
     * Method for adding category to database
     *
     * @param name Category's name
     * @param parentID Parent's ID
     */
    @Override
    public void addCategory(String name, int parentID) {
        LOGGER.debug("add category name:" + name + ", " + "parent id: " + parentID);
        try {
            template.update(ADD_CATEGORY, name, parentID == 0 ? null : parentID);
        }catch (Exception e) {
            LOGGER.error("error during creating category name: " + name + ", " + "parent id: " + parentID ,e);
        }
    }

    /**
     * Method for deleting category from database
     *
     * @param id Category's ID
     */
    @Override
    public void deleteCategory(int id) {
        LOGGER.debug("delete category with id:" + id);
        try {
            template.update(DELETE_CATEGORY, id);
        } catch (Exception e) {
            LOGGER.error("error during deleting category, id: " + id, e);
        }
    }

    /**
     * Method for editing the category in database
     *
     * @param id Category's ID
     * @param name Category's name
     * @param parID Parent's ID
     */
    @Override
    public void editCategory(int id, String name, int parID) {
        LOGGER.debug("edit category with id:" + id + " new name: " + name + "new parent id:" + parID);
        try {
            template.update(EDIT_CATEGORY, name, parID == 0 ? null : parID, id);
        }catch (Exception e) {
            LOGGER.error(" error during edit category with id:" + id + " new name: " + name + "new parent id:" + parID, e);
        }
    }

    /**
     * Method for editing the product in database
     *
     * @param id Product's ID
     * @param catID Category's ID
     * @param name Product's name
     * @param author Aythor's name
     * @param parID Parent's ID
     * @param price Product's price
     * @param count Quantity
     * @param date Date of creation
     * @param img Image's name
     */
    @Override
    public void editProduct(int id, int catID, String name, String author, int parID, double price, int count, int date, String img) {
        LOGGER.debug("edit product with id:" + id + " values: "  + name + ", " + catID + ", " + author + ", " +
                (parID == 0 ? null : parID) + ", " + price + ", " + count + ", " + date + ", " + img);
        try {
            template.update(EDIT_PRODUCT, catID, name, author, parID == 0 ? null : parID, price, count, date, img, id);
        } catch (Exception e) {
            LOGGER.error("error during edit product with id:" + id + " values: "  + name + ", " + catID + ", "
                    + author + ", " + (parID == 0 ? null : parID) + ", " + price + ", " + count + ", " + date + ", " + img, e);
        }
    }
}
