package com.revature.bookstore;

public class Account {

    private String username;
    private String password;
    private String firstname;
    private String lastname;

    public Account(String un, String pw, String fn, String ln){

        this.username = un;
        this.password = pw;
        this.firstname = fn;
        this.lastname = ln;

    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }
}
