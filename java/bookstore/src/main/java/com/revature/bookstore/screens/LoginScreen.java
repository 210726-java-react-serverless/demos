package com.revature.bookstore.screens;

import com.revature.bookstore.services.UserService;
import com.revature.bookstore.util.ScreenRouter;

import java.io.BufferedReader;

public class LoginScreen extends Screen {

    public LoginScreen(BufferedReader consoleReader, ScreenRouter router) {
        super("LoginScreen", "/login", consoleReader, router);
    }

    @Override
    public void render() throws Exception {

        System.out.println("Welcome to the log-in screen, please enter your Username and Password.");
        System.out.print("Please enter your Username: ");
        String userName = consoleReader.readLine();
        System.out.print("Please enter your Password: ");
        String password = consoleReader.readLine();

//        UserService us = new UserService(userRepos);
//        UserService.login(userName, password);

        System.out.println("Screen under construction, sending you back to the Welcome Screen.");
        router.navigate("/welcome");
    }

}
