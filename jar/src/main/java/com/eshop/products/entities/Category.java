package com.eshop.products.entities;


import org.springframework.stereotype.Component;

@Component
public class Category {
    private int categoryID;
    private String name;
    private int parentID;

    public Category() {
    }

    public Category(String name, int parentID) {
        this.name = name;
        this.parentID = parentID;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getParentID() {
        return parentID;
    }

    public void setParentID(int parentID) {
        this.parentID = parentID;
    }
}
