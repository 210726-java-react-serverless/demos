package com.revature.bookstore.screens;

import com.revature.bookstore.util.ScreenRouter;

import java.io.BufferedReader;

public class LoginScreen extends Screen {

    public LoginScreen(BufferedReader consoleReader, ScreenRouter router) {
        super("LoginScreen", "/login", consoleReader, router);
    }

    @Override
    public void render() {
        System.out.println("LoginScreen works!");
    }

}
