/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.patika.kredinbizdenservice;

import com.patika.kredinbizdenservice.model.ExampleDatabaseInitializer;
import com.patika.kredinbizdenservice.model.User;
import com.patika.kredinbizdenservice.model.factories.UserFactory;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;


/**
 *
 * @author berke
 */
public class Main {
    public static void main(String[] args) {
        ExampleDatabaseInitializer example = new ExampleDatabaseInitializer();
        example.initialize();
        
        // Aynı e-mail adresi ile bir kullanıcı kayıt olabilir.
        System.out.println("Ayni email: ");
        example.getUserDatabase().addUser(UserFactory.createUser("Berke", "Koca", LocalDate.parse("1999-01-02", DateTimeFormatter.ofPattern("yyyy-MM-dd")), "berkekocadere@gmail.com", "12345678", "123123123123", true));
        System.out.println("-------------------");
        
        
        // Kullanıcının şifresi SHA-512 ile şifrelenerek kullanıcı oluşturulmalıdır.
        System.out.println("Sifreleme SHA-512");
        Optional<User> userOptional = example.getUserDatabase().getUser("berkekocadere@gmail.com");
        User user = userOptional.orElse(null);
       
        if (null != user) {
            System.out.println(user.getPassword());
        }
        
        System.out.println("-------------------");
        
        // En çok başvuru yapan kullanıcıyı bulan methodu yazın.
        System.out.println("En cok basvuru yapan kullanici : ");
        System.out.println(example.getUserDatabase().UserWithMostApplications().toString());
        
        System.out.println("-------------------");
        
        // En yüksek kredi isteyen kullanıcıyı ve istediği tutarı bulan methodu yazın.
        System.out.println("En yuksek kredi isteyen kullaniciyi ve istedigi tutari bulan method");
        System.out.println(example.getUserDatabase().userWithHighestLoanAmount().toString());
        
        System.out.println("-------------------");
        
        // Son bir aylık yapılan başvuruları listeleyen methodu yazın.
        System.out.println("Son bir aylik yapilan basvurulari listeleyen method");
        System.out.println(example.getUserDatabase().lastApplications(1));
        
        System.out.println("-------------------");
        
        // Kampanya sayısı en çoktan aza doğru olacak şekilde kredi kartı tekliflerini listeleyen methodu yazın.
        System.out.println("Kampanya sayisi en coktan aza dogru olacak sekilde kredi karti tekliflerini listeleyen methodu yazin.");
        System.out.println(example.getBankDatabase().getListCreditCardFromMostCampaignToLeast().toString());

    }  
}
