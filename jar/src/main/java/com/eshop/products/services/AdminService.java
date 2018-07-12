package com.eshop.products.services;

public interface AdminService {
    void addProduct(int id, int catID, String name, String author, int parID, double price, int count, int date);
    void deleteProduct(int id);
    void addCategory(int id, String name, int parID);
    void deleteCategory(int id);
}
