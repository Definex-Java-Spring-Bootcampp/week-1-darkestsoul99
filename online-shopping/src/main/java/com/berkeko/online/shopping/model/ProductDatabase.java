/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.berkeko.online.shopping.model;

import java.util.List;

/**
 *
 * @author berke
 */
public class ProductDatabase {
    private List<Product> productList;

    public ProductDatabase(List<Product> productList) {
        this.productList = productList;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
    
    public void addProduct(Product product) {
        this.productList.add(product);
    }
    
}
