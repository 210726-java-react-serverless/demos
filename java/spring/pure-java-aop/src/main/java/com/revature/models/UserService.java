package com.revature.models;

public class UserService implements Service {

    @Override
    public String foo(String s) {
        System.out.println("This value was provided: " + s);
        return s.toUpperCase();
    }

}
