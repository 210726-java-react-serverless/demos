package com.revature.bookstore.screens;

import java.io.BufferedReader;

public class LoginScreen extends Screen {

    public LoginScreen(BufferedReader consoleReader) {
        super("LoginScreen", "/login", consoleReader);
    }

    @Override
    public void render() {
        System.out.println("LoginScreen works!");
    }

}
