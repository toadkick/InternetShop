package com.eshop.products.dao;

public interface AdminDAO {
    void addProduct(int catID, String name, String author, int parID, double price, int count, int date, String img);
    void editProduct(int id, int catID, String name, String author, int parID, double price, int count, int date, String img);
    void deleteProduct(int id);
    void addCategory(String name, int parID);
    void editCategory(int id, String name, int parID);
    void deleteCategory(int id);
}
