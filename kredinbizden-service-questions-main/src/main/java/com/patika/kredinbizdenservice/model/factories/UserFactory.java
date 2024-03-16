/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.patika.kredinbizdenservice.model.factories;

import com.patika.kredinbizdenservice.model.User;
import com.patika.kredinbizdenservice.model.UserDatabase;
import java.time.LocalDate;

/**
 *
 * @author berke
 */
public class UserFactory {
    
    public static User createUser(String name, String surname, LocalDate birthDate, String email, String password, String phoneNumber, boolean isActive) {
        User user = new User(
                name,
                surname,
                birthDate,
                email,
                password,
                phoneNumber,
                isActive
        );
        return user;
    }
    
}
