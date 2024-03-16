/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.berkeko.online.shopping.model;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author berkeko
 */
public class Customer {
    private String name;
    private String surname;
    private LocalDate dateOfBirth;
    private String addressInfo;
    private String email; //bir email ile bir kere kayıt olunabilir.
    private String phoneNumber;
    private List<Order> orderList;

    public Customer(String name, String surname, LocalDate dateOfBirth, String addressInfo, String email, String phoneNumber) {
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.addressInfo = addressInfo;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.orderList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddressInfo() {
        return addressInfo;
    }

    public void setAddressInfo(String addressInfo) {
        this.addressInfo = addressInfo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }
    // A customer can have many orders
    public void addOrder(Order order) {
        orderList.add(order);
    }

    public int getAge() {
        LocalDate currentDate = LocalDate.now();
        Period period = Period.between(this.dateOfBirth, currentDate);
        return period.getYears();
    }

    public long getTotalPurchaseAmount() {
        return this.getOrderList().stream()
                .flatMapToLong(order -> order.getProducts().stream()
                        .mapToLong(product -> Math.round(product.getPrice())))
                .sum();
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Customer: \n");
        sb.append("\tName: ").append(name).append("\n");
        sb.append("\tSurname: ").append(surname).append("\n");
        sb.append("\tAddress: ").append(addressInfo).append("\n");
        sb.append("\tEmail: ").append(email).append("\n");
        sb.append("\tPhone Number: ").append(phoneNumber).append("\n");
        return sb.toString();
    }

}
