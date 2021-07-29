package com.revature.bookstore.services;

import com.revature.bookstore.exceptions.InvalidRequestException;
import com.revature.bookstore.models.AppUser;
import com.revature.bookstore.repositories.UserRepository;

import java.io.File;

public class UserService {

    private final UserRepository userRepo;
    private File dataSource;

    public UserService(UserRepository userRepo){
        this.userRepo = userRepo;
    }


    public AppUser register(AppUser newUser){
        if(!validateUser(newUser)) throw new InvalidRequestException("Invalid user data provided...");

        userRepo.save(newUser);

        return newUser;
    }

    private boolean validateUser(AppUser user){
        if(user == null)return false;
        if(user.getFirstName() == null || user.getFirstName().trim().equals(""))return false;
        if(user.getLastName() == null || user.getLastName().trim().equals(""))return false;
        if(user.getEmail() == null || user.getEmail().trim().equals(""))return false;
        if(user.getUsername() == null || user.getFirstName().trim().equals(""))return false;

        return true;
    }

    public AppUser login(String username, String password){
        return userRepo.findByUserCredentials(username,password);
    }

}
