package com.revature.bookstore.services;

import com.revature.bookstore.exceptions.InvalidRequestException;
import com.revature.bookstore.models.AppUser;
import com.revature.bookstore.repository.UserRepository;

public class UserService {
    private final UserRepository userRepo;

    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    //Validate user input, store in UserRepo and return AppUser with repo_id
    public AppUser register(AppUser user) {
        if(!isValid(user)) {
            throw new InvalidRequestException("Invalid user data provided");
        }

        //pass validated user to UserRepository
        userRepo.save(user);

        return user;
    }

    //Return the AppUser associated with a given username and password
    public AppUser login(String username, String password) {
        return userRepo.findUserByCredentials(username, password);
    }

    private boolean isValid(AppUser user) {
        if(user == null) {
            return false;
        }
        if(user.getFirstName() == null || user.getFirstName().trim().equals("")) return false;
        if(user.getLastName() == null || user.getLastName().trim().equals("")) return false;
        if(user.getPassword() == null || user.getPassword().trim().equals("")) return false;
        if(user.getEmail() == null || user.getEmail().trim().equals("")) return false;
        if(user.getUsername() == null || user.getUsername().trim().equals("")) return false;

        //if a duplicate already exists in the db, reject
        if(userRepo.findById(user.getId()) != null) {
            return false;
        }

        return true;
    }
}
