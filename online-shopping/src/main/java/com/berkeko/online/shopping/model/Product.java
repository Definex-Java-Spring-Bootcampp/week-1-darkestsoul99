/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.berkeko.online.shopping.model;

import com.berkeko.online.shopping.enums.Category;

/**
 *
 * @author berkeko
 */
public class Product {
    // Product has name, category, price and stock number
    private String name;
    private Category category;
    private double price;
    private int stock;

    public Product(String name, Category category, double price, int stock) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.stock = stock;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n")
          .append("name : ").append(name + "\n")
          .append("category : ").append(category + "\n")
          .append("price : ").append(price + "\n")
          .append("stock : ").append(stock + "\n");
        return sb.toString();
    }
    
    
}
