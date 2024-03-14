/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.berkeko.online.shopping.model;

import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author berkeko
 */
public class Order {
    private Customer customerInfo;
    private List<Product> products; // An order can have many products
    private Invoice invoice; // An order has an invoice

    public Order(List<Product> products) {
        this.products = products;
        this.invoice = new Invoice(
                customerInfo.getName(), 
                customerInfo.getSurname(), 
                customerInfo.getAddressInfo(),
                products.stream().mapToDouble(product -> product.getPrice()).sum(),
                LocalDateTime.now(),
                products
        );
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
    
    public void addProduct(Product product) {
        products.add(product);
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }
}
