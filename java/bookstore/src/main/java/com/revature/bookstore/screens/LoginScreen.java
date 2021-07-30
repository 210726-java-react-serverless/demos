package com.revature.bookstore.screens;

import com.revature.bookstore.services.UserService;
import com.revature.bookstore.util.ScreenRouter;

import java.io.BufferedReader;

public class LoginScreen extends Screen {
    private final UserService userService;

    public LoginScreen(BufferedReader consoleReader, ScreenRouter router, UserService userService) {
        super("LoginScreen", "/login", consoleReader, router);
        this.userService = userService;
    }

    @Override
    public void render() throws Exception {
        System.out.println("\nLogin to your account!");

        System.out.print("Username: ");
        String username = consoleReader.readLine();

        System.out.print("Password: ");
        String password = consoleReader.readLine();

        System.out.printf("Username: %s\nPassword: %s\n", username, password);

        router.navigate("/welcome");

        if (userService.login(username, password)) {
            System.out.println("\nYou have logged in!");
        } else {
            System.out.println("You entered invalid credentials");
        }
    }

}
