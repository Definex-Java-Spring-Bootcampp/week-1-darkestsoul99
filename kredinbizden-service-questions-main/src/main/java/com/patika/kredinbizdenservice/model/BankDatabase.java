/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.patika.kredinbizdenservice.model;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author berkeko
 */
public class BankDatabase {
    private final List<Bank> BankList;

    public BankDatabase(List<Bank> BankList) {
        this.BankList = BankList;
    }

    public List<Bank> getBankList() {
        return BankList;
    }
    
    public List<CreditCard> getListCreditCardFromMostCampaignToLeast() {
            return BankList.stream()
            .flatMap(bank -> bank.getCreditCards().stream())
            .sorted(Comparator.comparingInt(card -> card.getCampaignList().size()))
            .collect(Collectors.toList());
    }
    
}
