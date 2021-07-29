package com.revature.bookstore.screens;

import com.revature.bookstore.util.ScreenRouter;

import java.io.BufferedReader;

public class LoginScreen extends Screen {


    public LoginScreen(BufferedReader consoleReader, ScreenRouter router) {
        super("LoginScreen", "/login", consoleReader, router);
    }


    @Override
    public void render() throws Exception {
        // TODO Login Screen
        System.out.println("LoginScreen works!");
        System.out.println("Screen under construction, sending you back to welcome.");
        router.navigate("/welcome");
    }
}
