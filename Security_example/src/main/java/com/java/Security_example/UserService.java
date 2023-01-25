package com.java.Security_example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private static UserRepo userRepo;

    public static User register(User user) {
        return (User) userRepo.save(user);
    }

    public User getDetails(String username) {
        return userRepo.findByUsername(username);
    }

     String getUserRoles(String username) {
        return userRepo.findByUsername(username).role;
    }

}