package com.revature.bookstore.screens;

public class LoginScreen extends Screen {
    public LoginScreen() {
        super("LoginScreen", "/login");
    }

    @Override
    public void render() throws Exception {
        String menu = "You're at the Login screen! Come back later!\n";
        System.out.println(menu);
    }
}
