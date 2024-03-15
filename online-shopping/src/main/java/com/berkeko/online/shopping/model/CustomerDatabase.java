/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.berkeko.online.shopping.model;

import java.time.LocalDate;
import java.util.List;
import java.util.Comparator;
import java.util.stream.Collectors;
/**
 *
 * @author berke
 */
public class CustomerDatabase {
    private List<Customer> customerList;

    public CustomerDatabase(List<Customer> customerList) {
        this.customerList = customerList;
    }

    public List<Customer> getCustomerList() {
        return customerList;
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

    public List<Long> getProductCountForCustomer(String customerName) {
        return this.customerList.stream()
                .filter(customer -> customer.getName().equals(customerName))
                .mapToLong(customer -> customer.getOrderList().stream().count())
                .boxed()
                .collect(Collectors.toList());
    }
    
    public double getRangeOfCustomersTotalPrice(String customerName, int minAge, int maxAge) {
        return this.customerList.stream()
                .filter(customer -> customer.getName().equals(customerName) &&
                                    customer.getAge() > minAge &&
                                    customer.getAge() < maxAge)
                .mapToDouble(customer -> customer.getTotalPurchaseAmount())
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
