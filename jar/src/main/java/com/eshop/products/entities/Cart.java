package com.eshop.products.entities;

public class Cart {
    private int product_id;
    private String login;
    private int count;
    private String productName;
    private int price;

    public Cart() {
    }

    public Cart(int product_id, String login, int count, String productName, int price) {
        this.product_id = product_id;
        this.login = login;
        this.count = count;
        this.productName = productName;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
