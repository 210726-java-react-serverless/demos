package com.revature.poc_lambda;

import com.mongodb.client.MongoCollection;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    private final MongoCollection<AppUser> userCollection;

    public UserRepository() {
        this.userCollection = MongoClientFactory.getInstance()
                                                .getConnection()
                                                .getDatabase("bookstore")
                                                .getCollection("users", AppUser.class);
    }

    public List<AppUser> findAllUsers() {

        List<AppUser> users = new ArrayList<>();

        try {
            userCollection.find().into(users);
        } catch (Exception e) {
            throw new RuntimeException("An unexpected exception occurred!");
        }

        return users;

    }
}
