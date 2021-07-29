package com.revature.bookstore.screens;

import com.revature.bookstore.services.UserService;
import com.revature.bookstore.util.ScreenRouter;

import java.io.BufferedReader;
import java.sql.SQLOutput;

public class LoginScreen extends Screen {

    private final UserService userService;

    public LoginScreen(BufferedReader consoleReader, ScreenRouter router, UserService userService) {
        super("LoginScreen", "/login", consoleReader, router);
        this.userService = userService;
    }

    @Override
    public void render() throws Exception {
        System.out.println("LoginScreen");
        System.out.print("Enter Username: ");

        String usernameInput = consoleReader.readLine();

        System.out.print("Enter Password: ");

        String passwordInput = consoleReader.readLine();

        if (userService.login(usernameInput,passwordInput)) {
            System.out.println("Successfully Logged In!");
            router.navigate("/dashboard");
        } else {
            System.out.println("Could not log you in.");
            router.navigate("/welcome");
        }

        //router.navigate("/welcome");
    }

}
