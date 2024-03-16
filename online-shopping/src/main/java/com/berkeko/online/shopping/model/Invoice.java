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
public class Invoice {
    private String customerName;
    private String customerSurname;
    private String addressInfo;
    private double totalBill;
    private LocalDateTime date;
    private List<Product> products;

    public Invoice(String customerName, String customerSurname, String addressInfo, double totalBill, LocalDateTime date, List<Product> products) {
        this.customerName = customerName;
        this.customerSurname = customerSurname;
        this.addressInfo = addressInfo;
        this.totalBill = totalBill;
        this.date = date;
        this.products = products;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerSurname() {
        return customerSurname;
    }

    public void setCustomerSurname(String customerSurname) {
        this.customerSurname = customerSurname;
    }

    public String getAddressInfo() {
        return addressInfo;
    }

    public void setAddressInfo(String addressInfo) {
        this.addressInfo = addressInfo;
    }

    public double getTotalBill() {
        return totalBill;
    }

    public void setTotalBill(double totalBill) {
        this.totalBill = totalBill;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Invoice Details:\n");
        sb.append("Customer Name: ").append(customerName).append("\n");
        sb.append("Customer Surname: ").append(customerSurname).append("\n");
        sb.append("Address Info: ").append(addressInfo).append("\n");
        sb.append("Total Bill: ").append(totalBill).append("\n");
        sb.append("Date: ").append(date).append("\n");
        sb.append("Products:\n");
        for (Product product : products) {
            sb.append("----------------------------- \n");
            sb.append(product.toString()).append("\n");
            sb.append("----------------------------- \n");
        }
        return sb.toString();
    }
}
