/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.berkeko.online.shopping.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author berke
 */
public class ProductDatabase {
    private static ProductDatabase instance = null;
    private List<Product> productList;

    public static ProductDatabase getInstance() {
        if (instance == null) {
            instance = new ProductDatabase();
        }
        return instance;
    }
    
    public ProductDatabase() {
        this.productList = new ArrayList<>();
    }

    public List<Product> getProductList() {
        return productList;
    }
    
    public Optional<Product> getProduct(String productName) {
        return productList.stream()
                .filter(product -> product.getName().equals(productName))
                .findFirst();
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
    
    public void addProduct(Product product) {
        this.productList.add(product);
    }
    
}
