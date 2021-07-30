package com.revature.bookstore.services;

import com.revature.bookstore.exceptions.InvalidRequestException;
import com.revature.bookstore.models.AppUser;
import com.revature.bookstore.repositories.UserRepository;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;

public class UserService {

    private final UserRepository userRepo;

    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public AppUser register(AppUser newUser) {
        if (!isUserValid(newUser)) {
            throw new InvalidRequestException("Invalid user data provided!");
        }
        return userRepo.save(newUser);
    }

    public boolean login(String username, String password) {
        File file = new File("src/main/resources/data.txt");

        try {
            BufferedReader fileReader = new BufferedReader(new FileReader(file));

            String str;
            while ((str = fileReader.readLine()) != null) {
                if (isUserValid(str, username, password)) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    private boolean isUserValid(String data, String username, String password) {
        String[] tokens = data.split(":");

        if (tokens[4].equals(username) && tokens[5].equals(password)) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isUserValid(AppUser user) {
        if (user == null) return false;
        if (user.getFirstName() == null || user.getFirstName().trim().equals("")) return false;
        if (user.getLastName() == null || user.getLastName().trim().equals("")) return false;
        if (user.getEmail() == null || user.getEmail().trim().equals("")) return false;
        if (user.getUsername() == null || user.getUsername().trim().equals("")) return false;
        return user.getPassword() != null && !user.getPassword().trim().equals("");
    }
}
