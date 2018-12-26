package com.eshop.products.entities;

import org.springframework.stereotype.Component;

@Component
public class Product {
    private int productID;
    private int categoryID;
    private String name;
    private String author;
    private int parentID;
    private double price;
    private int count;
    private int date;
    private String imgSource;

    public Product() {
    }

    public Product(int productID, int categoryID, String name, String author, int parentID, double price, int count, int date) {
        this.productID = productID;
        this.categoryID = categoryID;
        this.name = name;
        this.author = author;
        this.parentID = parentID;
        this.price = price;
        this.count = count;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productID=" + productID +
                ", categoryID=" + categoryID +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", parentID=" + parentID +
                ", price=" + price +
                ", count=" + count +
                ", date=" + date +
                '}';
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getParentID() {
        return parentID;
    }

    public void setParentID(int parentID) {
        this.parentID = parentID;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public String getImgSource() {
        return imgSource;
    }

    public void setImgSource(String imgSource) {
        this.imgSource = imgSource;
    }
}
