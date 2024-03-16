/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.patika.kredinbizdenservice.model.factories;

import com.patika.kredinbizdenservice.model.Loan;
import com.patika.kredinbizdenservice.enums.LoanType; // Import LoanType enum
import com.patika.kredinbizdenservice.model.ConsumerLoan;
import com.patika.kredinbizdenservice.model.HouseLoan;
import com.patika.kredinbizdenservice.model.VechileLoan;
import java.math.BigDecimal;

public class LoanFactory {
    
    public static Loan createLoan(LoanType loanType, BigDecimal amount, Integer installment, Double interestRate) {
        // Determine loan parameters based on loan type
        switch (loanType) {
            case IHTIYAC_KREDISI -> {
                return new ConsumerLoan(amount, installment, interestRate);
            }
            case KONUT_KREDISI -> {
                return new HouseLoan(amount, installment, interestRate);
            }
            case ARAC_KREDISI -> {
                return new VechileLoan(amount, installment, interestRate);
            }
            default -> throw new IllegalArgumentException("Unsupported loan type: " + loanType);
        }
    }
}

