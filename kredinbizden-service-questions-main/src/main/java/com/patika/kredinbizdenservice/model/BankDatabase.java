/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.patika.kredinbizdenservice.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 *
 * @author berkeko
 */
public class BankDatabase {
    private static BankDatabase instance = null;
    private static List<Bank> BankList = new ArrayList<Bank>();

    public static BankDatabase getInstance() {
        if (instance == null) {
            instance = new BankDatabase();
        }
        return instance;
    }
    
    public List<Bank> getBankList() {
        return BankList;
    }
    
    public void addBank(Bank bank) {
        if (!getBank(bank.getName()).isEmpty()) {
            System.out.println("Bank is already exists! ");
        } else {
            BankList.add(bank);
        }
    }
    
    public Optional<Bank> getBank(String bankName) {
        return BankList.stream()
                .filter(bank -> bank.getName().equals(bankName))
                .findFirst();
    }
    
    public List<CreditCard> getListCreditCardFromMostCampaignToLeast() {
            return BankList.stream()
            .flatMap(bank -> bank.getCreditCards().stream())
            .sorted(Comparator.comparingInt(card -> card.getCampaignList().size()))
            .collect(Collectors.toList());
    }
    
}
