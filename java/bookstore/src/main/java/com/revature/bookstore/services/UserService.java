package com.revature.bookstore.services;

import com.revature.bookstore.exceptions.invalidRequestException;
import com.revature.bookstore.models.AppUser;
import com.revature.bookstore.repositories.UserRepository;

import java.io.FileNotFoundException;

public class UserService {

    private final UserRepository userRepo;
    private UserRepository userRepo1;

    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public AppUser Register(AppUser newUser) {

        if (!Valid_User(newUser)) {
            throw new invalidRequestException("Invalid user data provided!");
        }

        return userRepo.Save(newUser);
    }

    public AppUser Login(String username, String password) {

        AppUser target = userRepo.FindByID(username.hashCode());

        try {

            if (target.Get_Username().equals(username) &&
                    target.Get_Password().equals(password)) {
                System.out.println("Success");
            } else { System.err.println("Fail"); }

        } catch (Exception NullPointerException) {
            System.err.println("Did not find user");
        }

        return target;
    }

    private boolean Valid_User(AppUser user) {
        if (user == null) { return false; }

        if (user.Get_First_Name() == null || user.Get_First_Name().equals("")) { return false;}
        if (user.Get_First_Name() == null || user.Get_First_Name().equals("")) { return false;}
        if (user.Get_First_Name() == null || user.Get_First_Name().equals("")) { return false;}
        if (user.Get_First_Name() == null || user.Get_First_Name().equals("")) { return false;}
        if (user.Get_First_Name() == null || user.Get_First_Name().equals("")) { return false;}
        if (user.Get_First_Name() == null || user.Get_First_Name().equals("")) { return false;}

        return user.Get_Password() != null && !user.Get_Password().trim().equals("");
    }
}
