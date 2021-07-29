package com.revature.bookstore.services;

import com.revature.bookstore.exceptions.InvalidRequestException;
import com.revature.bookstore.models.AppUser;
import com.revature.bookstore.repositories.UserRepository;


public class UserService {

    private final UserRepository userRepo;

    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public AppUser register(AppUser newUser, int iterator) {
        if (!isUserValid(newUser)) {
            // halt here, and raise a custom exception
            throw new InvalidRequestException("Invalid user data provided!");
        }

        return userRepo.save(newUser, iterator);
    }

    public AppUser login(String username, String password) {

        AppUser[] users = new AppUser[1];
        users = userRepo.getUsers();

        for (int i = 0; i < users.length; i++) {
            if (users[i].getUsername() == username) {
                if (users[i].getPassword() == password) {
                    System.out.println("Access Granted.");
                }
                else System.out.println("The FBI is on to you");
                break;
            }
            if (i == users.length - 1) {
                System.out.println("Username not found in system.");
            }

        }

        return null;
    }

    private boolean isUserValid(AppUser user) {
        if (user == null) return false;

        if (user.getFirstName() == null || user.getFirstName().trim().equals("")) return false;
        if (user.getLastName() == null || user.getLastName().trim().equals("")) return false;
        if (user.getEmail() == null || user.getEmail().trim().equals("")) return false;
        if (user.getUsername() == null || user.getUsername().trim().equals("")) return false;
        return !(user.getPassword() == null || user.getPassword().trim().equals(""));
    }


}
