package com.revature.bookstore.services;

import com.revature.bookstore.exceptions.InvalidRequestException;
import com.revature.bookstore.models.AppUser;
import com.revature.bookstore.repositories.UserRepository;

public class UserService {

    private final UserRepository userRepo;

<<<<<<< HEAD
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

        return null;
    }

=======
    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public AppUser register(AppUser newUser) {

        if (!isUserValid(newUser)) {
            throw new InvalidRequestException("Invalid user data provided!");
        }

        return userRepo.save(newUser);

    }

    public AppUser login(String username, String password) {
        return null;
    }

    private boolean isUserValid(AppUser user) {
        if (user == null) return false;
        if (user.getFirstName() == null || user.getFirstName().trim().equals("")) return false;
        if (user.getLastName() == null || user.getLastName().trim().equals("")) return false;
        if (user.getEmail() == null || user.getEmail().trim().equals("")) return false;
        if (user.getUsername() == null || user.getUsername().trim().equals("")) return false;
        return user.getPassword() != null && !user.getPassword().trim().equals("");
    }
>>>>>>> 846980801a1c42168f47cf961a68229b941ed89f
}
