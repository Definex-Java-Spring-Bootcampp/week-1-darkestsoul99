/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.patika.kredinbizdenservice.model;

import com.patika.kredinbizdenservice.enums.LoanType;
import com.patika.kredinbizdenservice.enums.SectorType;
import com.patika.kredinbizdenservice.model.factories.BankFactory;
import com.patika.kredinbizdenservice.model.factories.CampaignFactory;
import com.patika.kredinbizdenservice.model.factories.CreditCardFactory;
import com.patika.kredinbizdenservice.model.factories.LoanFactory;
import com.patika.kredinbizdenservice.model.factories.UserFactory;
import com.patika.kredinbizdenservice.model.factories.ApplicationFactory;
import com.patika.kredinbizdenservice.model.Bank;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author berke
 */
public class ExampleDatabaseInitializer {
    private UserDatabase userDatabase;
    private BankDatabase bankDatabase;
    
    public void initialize() {
        initializeDatabases();
        initializeBanks();
        initializeUsers();
        initializeApplications();
    }
    
    public void initializeDatabases() {
        userDatabase = UserDatabase.getInstance();
        bankDatabase = BankDatabase.getInstance();
    }
    
    public void initializeUsers() {
        userDatabase.addUser(UserFactory.createUser("Berke", "Kocadere", LocalDate.parse("1999-04-05", DateTimeFormatter.ofPattern("yyyy-MM-dd")), "berkekocadere@gmail.com", "12345678", "123123123123", true));
        userDatabase.addUser(UserFactory.createUser("John", "Doe", LocalDate.parse("1995-05-10", DateTimeFormatter.ofPattern("yyyy-MM-dd")), "john.doe@gmail.com", "432432432432", "903030303", true));
        userDatabase.addUser(UserFactory.createUser("Sam", "Altman", LocalDate.parse("1990-01-12", DateTimeFormatter.ofPattern("yyyy-MM-dd")), "sam.altman@gmail.com", "21314345345", "234234234234", true));
        userDatabase.addUser(UserFactory.createUser("Samantha", "Cleveland", LocalDate.parse("1997-07-02", DateTimeFormatter.ofPattern("yyyy-MM-dd")), "samantha.cleveland@gmail.com", "213424324", "324324234324", true));
    }

    public void initializeApplications() {
        Optional<Bank> bankOptional = bankDatabase.getBank("Akbank");
        Bank bank = bankOptional.orElse(null);

        Optional<User> userOptional = userDatabase.getUser("berkekocadere@gmail.com");
        User user = userOptional.orElse(null);

        if (bank != null && user != null) {
            List<CreditCard> creditCards = bank.getCreditCards();
            if (!creditCards.isEmpty()) { // Check if the list is not empty
                CreditCard firstCreditCard = creditCards.get(0); // Retrieve the first credit card from the list
                user.addApplication(ApplicationFactory.createApplication(firstCreditCard, user, LocalDateTime.now()));
            }
        }
        
        bankOptional = bankDatabase.getBank("Yapıkredi");
        bank = bankOptional.orElse(null);

        userOptional = userDatabase.getUser("john.doe@gmail.com");
        user = userOptional.orElse(null);

        if (bank != null && user != null) {
            List<CreditCard> creditCards = bank.getCreditCards();
            List<Loan> LoanList = bank.getLoanList();
            if (!creditCards.isEmpty()) { // Check if the list is not empty
                CreditCard firstCreditCard = creditCards.get(0); // Retrieve the first credit card from the list
                Loan secondLoan = LoanList.get(1);
                user.addApplication(ApplicationFactory.createApplication(secondLoan, user, LocalDateTime.now()));
                user.addApplication(ApplicationFactory.createApplication(firstCreditCard, user, LocalDateTime.now()));
            }
        }

        bankOptional = bankDatabase.getBank("Yapıkredi");
        bank = bankOptional.orElse(null);

        userOptional = userDatabase.getUser("samantha.cleveland@gmail.com");
        user = userOptional.orElse(null);

        if (bank != null && user != null) {
            List<Loan> LoanList = bank.getLoanList();
            if (!LoanList.isEmpty()) { // Check if the list is not empty
                Loan firstLoan = LoanList.get(0); // Retrieve the first credit card from the list
                user.addApplication(ApplicationFactory.createApplication(firstLoan, user, LocalDateTime.now()));
            }
        }
    }

    
    public void initializeBanks() {
        bankDatabase.addBank(BankFactory.createBank(
                "Akbank", 
                Arrays.asList(
                        LoanFactory.createLoan(LoanType.IHTIYAC_KREDISI, BigDecimal.valueOf(50000), 12, 5.10),
                        LoanFactory.createLoan(LoanType.ARAC_KREDISI, BigDecimal.valueOf(100000), 12, 4.15),
                        LoanFactory.createLoan(LoanType.KONUT_KREDISI, BigDecimal.valueOf(500000), 120, 2.90)
                ),
                Arrays.asList(
                    CreditCardFactory.createCreditCard(BigDecimal.valueOf(630), 
                        Arrays.asList(
                            CampaignFactory.createCampaign("Market Campaign", "Content1", LocalDate.parse("2024-08-10", DateTimeFormatter.ofPattern("yyyy-MM-dd")), LocalDate.parse("2024-09-10", DateTimeFormatter.ofPattern("yyyy-MM-dd")), LocalDate.parse("2024-10-10", DateTimeFormatter.ofPattern("yyyy-MM-dd")), SectorType.MARKET),
                            CampaignFactory.createCampaign("Travel Campaign", "Content2", LocalDate.parse("2024-08-10", DateTimeFormatter.ofPattern("yyyy-MM-dd")), LocalDate.parse("2024-09-10", DateTimeFormatter.ofPattern("yyyy-MM-dd")), LocalDate.parse("2024-10-10", DateTimeFormatter.ofPattern("yyyy-MM-dd")), SectorType.TRAVELS),
                            CampaignFactory.createCampaign("Other Campaign", "Content3", LocalDate.parse("2024-08-10", DateTimeFormatter.ofPattern("yyyy-MM-dd")), LocalDate.parse("2024-09-10", DateTimeFormatter.ofPattern("yyyy-MM-dd")), LocalDate.parse("2024-10-10", DateTimeFormatter.ofPattern("yyyy-MM-dd")), SectorType.OTHERS)
                        ),
                        "Akbank"
                    )
                )
        ));
        
        bankDatabase.addBank(BankFactory.createBank(
                "Yapikredi", 
                Arrays.asList(
                        LoanFactory.createLoan(LoanType.IHTIYAC_KREDISI, BigDecimal.valueOf(50000), 12, 5.00),
                        LoanFactory.createLoan(LoanType.ARAC_KREDISI, BigDecimal.valueOf(100000), 12, 4.10),
                        LoanFactory.createLoan(LoanType.KONUT_KREDISI, BigDecimal.valueOf(500000), 120, 2.80)
                ),
                Arrays.asList(
                    CreditCardFactory.createCreditCard(BigDecimal.valueOf(500), 
                        Arrays.asList(
                            CampaignFactory.createCampaign("Market Campaign", "Content1", LocalDate.parse("2024-08-10", DateTimeFormatter.ofPattern("yyyy-MM-dd")), LocalDate.parse("2024-09-10", DateTimeFormatter.ofPattern("yyyy-MM-dd")), LocalDate.parse("2024-10-10", DateTimeFormatter.ofPattern("yyyy-MM-dd")), SectorType.MARKET),
                            CampaignFactory.createCampaign("Travel Campaign", "Content2", LocalDate.parse("2024-08-10", DateTimeFormatter.ofPattern("yyyy-MM-dd")), LocalDate.parse("2024-09-10", DateTimeFormatter.ofPattern("yyyy-MM-dd")), LocalDate.parse("2024-10-10", DateTimeFormatter.ofPattern("yyyy-MM-dd")), SectorType.TRAVELS),
                            CampaignFactory.createCampaign("Other Campaign", "Content3", LocalDate.parse("2024-08-10", DateTimeFormatter.ofPattern("yyyy-MM-dd")), LocalDate.parse("2024-09-10", DateTimeFormatter.ofPattern("yyyy-MM-dd")), LocalDate.parse("2024-10-10", DateTimeFormatter.ofPattern("yyyy-MM-dd")), SectorType.OTHERS)
                        ),
                        "Yapikredi"
                    )
                )
        ));
    }

    public UserDatabase getUserDatabase() {
        return userDatabase;
    }

    public BankDatabase getBankDatabase() {
        return bankDatabase;
    }
    
}
