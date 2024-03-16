package com.patika.kredinbizdenservice.model.factories;

import com.patika.kredinbizdenservice.model.Application;
import com.patika.kredinbizdenservice.model.Product;
import com.patika.kredinbizdenservice.model.User;
import java.time.LocalDateTime;

public class ApplicationFactory {
    
    public static Application createApplication(Product product, User user, LocalDateTime localDateTime) {
        return new Application(product, user, localDateTime);
    }
}
