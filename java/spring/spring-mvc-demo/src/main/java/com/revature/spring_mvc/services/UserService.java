package com.revature.spring_mvc.services;

import com.revature.spring_mvc.exceptions.InvalidRequestException;
import com.revature.spring_mvc.exceptions.ResourceNotFoundException;
import com.revature.spring_mvc.models.AppUser;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserService {

    private static int nextId = 6;
    List<AppUser> users;

    public UserService() {
        users = new ArrayList<>(Arrays.asList(
                new AppUser(1, "Wezley", "Singleton", "wezley.singleton@revature.com", "wsingleton", "revature"),
                new AppUser(2, "Alice", "Anderson", "alice.anderson@revature.com", "aanderson", "password"),
                new AppUser(3, "Bob", "Bailey", "bob.bailey@revature.com", "bbailey", "p4ssw0rd"),
                new AppUser(4, "Chris", "Cantrell", "chris.cantrell@revature.com", "ccantrell", "drowssap"),
                new AppUser(5, "Daniel", "Davis", "daniel.davis@revature.com", "ddavis", "dr0wss4p")
        ));
    }

    public List<AppUser> getAllUsers_json() {
        throw new RuntimeException("Test throw.");
    }

    public AppUser getById(int id) {

        if (id <= 0) {
            throw new InvalidRequestException();
        }

        return users.stream()
                    .filter(user -> user.getId() == id)
                    .findFirst()
                    .orElseThrow(RuntimeException::new);

    }

}
