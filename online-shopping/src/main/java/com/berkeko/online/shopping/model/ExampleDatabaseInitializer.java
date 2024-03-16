/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.berkeko.online.shopping.model;

import com.berkeko.online.shopping.enums.Category;
import java.time.LocalDate;
import java.time.Month;

/**
 *
 * @author berke
 */
public class ExampleDatabaseInitializer {
    private CustomerDatabase customerDatabase;
    private ProductDatabase productDatabase;
    
    public void initialize() {
        customerDatabase = CustomerDatabase.getInstance();
        productDatabase = ProductDatabase.getInstance();
        
        initializeCustomers();
        initializeProducts();
    }
    
    public void initializeCustomers() {
        customerDatabase.addCustomer(new Customer("Berke", "Kocadere", LocalDate.of(1997, Month.APRIL, 5), "Izmir", "berkekocadere@gmail.com", "123123123123"));
        customerDatabase.addCustomer(new Customer("John", "Doe", LocalDate.of(1990, Month.FEBRUARY, 10), "New York", "john.doe@gmail.com", "324324234234"));
        customerDatabase.addCustomer(new Customer("Sam", "Altman", LocalDate.of(1996, Month.AUGUST, 30), "Washington", "sam.altman@gmail.com", "4324234234234"));
        customerDatabase.addCustomer(new Customer("Berke", "Kucukdere", LocalDate.of(1996, Month.OCTOBER, 15), "Istanbul", "berkekucukdere@gmail.com", "234324234234"));
    }
    
    public void initializeProducts() {
        productDatabase.addProduct(new Product("Bilgisayar", Category.ELEKTRONIK, 15000, 100));
        productDatabase.addProduct(new Product("Cep Telefonu", Category.ELEKTRONIK, 20000, 1000));
        productDatabase.addProduct(new Product("Buzdolabi", Category.BEYAZ_ESYA, 5000, 500));
        productDatabase.addProduct(new Product("Camasir Makinesi", Category.BEYAZ_ESYA, 11000, 600));
        productDatabase.addProduct(new Product("Koltuk", Category.MOBILYA, 15000, 800));
        productDatabase.addProduct(new Product("Pantolon", Category.KIYAFET, 500, 1000));
    }

    public CustomerDatabase getCustomerDatabase() {
        return customerDatabase;
    }

    public ProductDatabase getProductDatabase() {
        return productDatabase;
    }
    
    
}
