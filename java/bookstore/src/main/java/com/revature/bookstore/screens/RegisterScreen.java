package com.revature.bookstore.screens;

import com.revature.bookstore.models.AppUser;
import com.revature.bookstore.services.UserService;
import com.revature.bookstore.util.ScreenRouter;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class RegisterScreen extends Screen {

    private final UserService userService;

    public RegisterScreen(BufferedReader consoleReader, ScreenRouter router, UserService userService) {

        super("RegisterScreen", "/register", consoleReader, router);

        this.userService=userService;

    }

    @Override
    public void render() throws Exception {

        System.out.print("Enter username \n> ");

        String user = consoleReader.readLine();

        System.out.print("Enter password \n> ");

        String pass = consoleReader.readLine();

        System.out.print("Enter email \n> ");

        String email = consoleReader.readLine();

        System.out.print("Enter first name \n> ");

        String firstName = consoleReader.readLine();

        System.out.print("Enter last name \n> ");

        String lastName = consoleReader.readLine();

        AppUser newUser = new AppUser(user,pass, email,firstName,lastName);

        userService.register(newUser);

        router.navigate("/welcome");

    }
}
