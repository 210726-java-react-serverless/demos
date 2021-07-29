package com.revature.bookstore.screens;

import java.io.BufferedReader;

public class LoginScreen extends Screen{

    public LoginScreen(BufferedReader consoleReader, ScreenRouter router) {
        super("LoginScreen", "/login", consoleReader, router);
    }

    @Override
    public void render() throws Exception {
        System.out.println("LoginScreen works!");
        System.out.println("Screen under construction, sending you back to the Welcome Screen.");
        router.navigate("/welcome");

    }
