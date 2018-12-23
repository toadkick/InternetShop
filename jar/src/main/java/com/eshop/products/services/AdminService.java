package com.eshop.products.services;

public interface AdminService {
    void addProduct(int catID, String name, String author, int parID, double price, int count, int date);
    void deleteProduct(int id);
    void addCategory(String name, int parID);
    void deleteCategory(int id);
}
