package com.revature.bookstore.screens;

public class RegisterScreen extends Screen{

    private String username;
    private String password;
    private String firstName;
    private String lastName;

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public RegisterScreen(String name, String route) {
        super(name, route);
    }

    @Override
    public void render() throws Exception {

    }
}
