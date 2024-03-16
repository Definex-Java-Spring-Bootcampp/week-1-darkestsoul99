package com.patika.kredinbizdenservice.model;

import java.util.List;

public class Bank {

    private String name;
    private List<Loan> loanList;
    private List<CreditCard> creditCards;

    public Bank(String name, List<Loan> loanList, List<CreditCard> creditCards) {
        this.name = name;
        this.loanList = loanList;
        this.creditCards = creditCards;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Loan> getLoanList() {
        return loanList;
    }

    public void setLoanList(List<Loan> loanList) {
        this.loanList = loanList;
    }
    
    public void addLoan(Loan loan) {
        this.loanList.add(loan);
    }

    public List<CreditCard> getCreditCards() {
        return creditCards;
    }

    public void setCreditCards(List<CreditCard> creditCards) {
        this.creditCards = creditCards;
    }
    
    public void addCreditCard(CreditCard creditCard) {
        this.creditCards.add(creditCard);
    }
    
    @Override
    public String toString() {
        return "Bank{" +
                "name='" + name + '\'' +
                ", loanList=" + loanList +
                '}';
    }
}
