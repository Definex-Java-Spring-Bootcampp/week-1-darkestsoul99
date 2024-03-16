package com.patika.kredinbizdenservice.model;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.time.LocalDateTime;

public class UserDatabase {
    private static UserDatabase instance = null;
    private static List<User> UserList = new ArrayList<User>();
    
    public static UserDatabase getInstance() {
        if (instance == null) {
            instance = new UserDatabase();
        }
        return instance;
    }

    public void addUser(User user) {
        if (!getUser(user.getEmail()).isEmpty()) {
            System.out.println("Email is already used ! ");
        } else {
            UserList.add(user);
        }
    }

    public Optional<User> getUser(String email) {
        return UserList.stream()
                .filter(user -> user.getEmail().equals(email))
                .findFirst();
    }
    
    public List<User> getUserList() {
        return UserList;
    }
    
    public Optional<User> UserWithMostApplications() {
        return UserList.stream()
                .max(Comparator.comparingInt(user -> user.getApplicationList().size()));
    }

    public Optional<User> userWithHighestLoanAmount() {
        return UserList.stream()
                .filter(user -> !user.getApplicationList().isEmpty())
                .max(Comparator.comparing(user ->
                        user.getApplicationList()
                            .stream()
                            .filter(application -> application.getLoan() != null)
                            .mapToDouble(application -> application.getLoan().getAmount().doubleValue())
                            .sum()));
    }

    public List<LocalDateTime> lastApplications(int months) {
        return UserList.stream()
            .flatMap(user -> user.getApplicationList().stream())
            .map(Application::getLocalDateTime)
            .filter(dateTime -> dateTime.isAfter(LocalDateTime.now().minusMonths(months)))
            .collect(Collectors.toList());
    }
    
    public List<Application> userGetAllApplications(String email) {
        Optional<User> userOptional = getUser(email);
        if (userOptional.isPresent()) {
            return userOptional.get().getApplicationList();
        } else {
            throw new IllegalArgumentException("User with email " + email + " not found.");
        }
    }
}

