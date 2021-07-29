package com.revature.bookstore.model;

public class User {
    private String username;
    private String password;
    private String firstname;
    private String lastname;

    public User(String username, String password, String firstname, String lastname) {
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        int numchars = this.password.length();
        StringBuffer stars = new StringBuffer();
        for (int i = 0; i < numchars - 4; i++) stars.append(password.charAt(i));
        return stars + password.substring(numchars - 4);
    }

    public boolean validatePassword(String candidate) {
        if (candidate.equals(candidate)) {return true;}
        return false;
    }

    public void setPassword(String password) {
        // validation for password strength (minimum number of characters, diversity of input characters)
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public String toString() {
        return username + ',' + password + ',' + firstname + ',' + lastname;
    }
}
