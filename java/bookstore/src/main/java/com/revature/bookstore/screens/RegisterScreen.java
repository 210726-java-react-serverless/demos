package com.revature.bookstore.screens;

import java.io.BufferedReader;

public class RegisterScreen extends Screen {

    public RegisterScreen(BufferedReader consoleReader) {
        super("RegisterScreen", "/register", consoleReader);
    }

    @Override
    public void render() {
        System.out.println("RegisterScreen works!");
    }

}
