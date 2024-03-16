/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.patika.kredinbizdenservice.model.factories;

import com.patika.kredinbizdenservice.model.Campaign;
import com.patika.kredinbizdenservice.model.CreditCard;
import java.math.BigDecimal;
import java.util.List;
/**
 *
 * @author berke
 */
public class CreditCardFactory {
    public static CreditCard createCreditCard(BigDecimal fee, List<Campaign> campaignList, String bank) {
        CreditCard creditCard = new CreditCard(fee, campaignList);
        creditCard.setBank(bank);
        return creditCard;
    }
}
