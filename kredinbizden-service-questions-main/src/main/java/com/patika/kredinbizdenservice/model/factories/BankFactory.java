/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.patika.kredinbizdenservice.model.factories;

import com.patika.kredinbizdenservice.model.Bank;
import com.patika.kredinbizdenservice.model.BankDatabase;
import com.patika.kredinbizdenservice.model.CreditCard;
import com.patika.kredinbizdenservice.model.Loan;
import java.util.List;

/**
 *
 * @author berke
 */
public class BankFactory {
    
    public static Bank createBank(String name, List<Loan> loanList, List<CreditCard> creditCards) {
        Bank bank = new Bank(name, loanList, creditCards);
        return bank;
    }
}
