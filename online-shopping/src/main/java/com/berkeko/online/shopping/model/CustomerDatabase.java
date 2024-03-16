/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.berkeko.online.shopping.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
/**
 *
 * @author berke
 */
public class CustomerDatabase {
    private static CustomerDatabase instance = null;
    private List<Customer> customerList;
    
    public static CustomerDatabase getInstance() {
        if (instance == null) {
            instance = new CustomerDatabase();
        }
        return instance;
    }
    
    public CustomerDatabase() {
        this.customerList = new ArrayList<>();
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }
    
    public Optional<Customer> getCustomer(String email) {
        return customerList.stream()
                .filter(customer -> customer.getEmail().equals(email))
                .findFirst();
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }
    
    public void addCustomer(Customer customer) {
        this.customerList.add(customer);
    }
    
    public long getCustomerCount() {
        return this.customerList.stream()
                .count();
    }

    public int getProductCountForCustomer(String customerName) {
        return this.customerList.stream()
                .filter(customer -> customer.getName().equals(customerName))
                .mapToInt(customer -> customer.getOrderList().stream()
                        .mapToInt(order -> order.getProducts().size())
                        .sum())
                .sum();
    }
    
    public double getRangeOfCustomersTotalPrice(String customerName, int minAge, int maxAge) {
        return this.customerList.stream()
                .filter(customer -> customer.getName().equals(customerName) &&
                                    customer.getAge() > minAge &&
                                    customer.getAge() < maxAge)
                .mapToDouble(Customer::getTotalPurchaseAmount)
                .sum();
    }
    

    public List<Invoice> getInvoicesWithTotalBillMoreThanAmount(double amount) {
        return this.customerList.stream()
                .flatMap(customer -> customer.getOrderList().stream())
                .filter(order -> order.getInvoice().getTotalBill() > amount)
                .map(order -> order.getInvoice())
                .toList();
    }
    
}
