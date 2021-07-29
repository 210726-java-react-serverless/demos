package com.revature.bookstore.services;

import com.revature.bookstore.exceptions.InvalidRequestException;
import com.revature.bookstore.models.AppUser;
import com.revature.bookstore.repositories.UserRepository;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class UserService {

    private final UserRepository userRepo;

    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }
    public UserService() { this.userRepo = null; }

    public AppUser register(AppUser newUser) {

        if (!isUserValid(newUser)) {
            throw new InvalidRequestException("Invalid user data provided!");
        }

        return userRepo.save(newUser);

    }

    public AppUser login(String username, String password) {

        boolean grantAccess = false;

        String userName = username;
        String passWord = password;

        File file = new File("src/main/resources/data.txt");
        try {
            //Scanner opens and reads file
            Scanner read = new Scanner(file).useDelimiter(":");

            //count the lines
            int numOfLines = 0;
            while (read.hasNextLine()) {
                numOfLines++;
                try {
                    read.nextLine();
                } catch(NoSuchElementException nsee) {
                    break;
                }
            }

            for(int i=0; i<numOfLines; i++) {
                if (read.nextLine().equals(userName)) { // if the same user name
                    i++;
                    if (read.nextLine().equals(password)) { // check password
                        grantAccess = true; // if also same, change boolean to true
                        break; // and break the for-loop
                    }
                }
            }
            read.close();
            if (grantAccess = true) {
                System.out.println("Access Granted.");
                //TODO make an actual link to the dashboard
            } else {
                System.out.println("The username or password you entered is wrong.");
            }

        } catch ( FileNotFoundException fnfe) {
            System.out.println("404, file not found");
        }



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
}
