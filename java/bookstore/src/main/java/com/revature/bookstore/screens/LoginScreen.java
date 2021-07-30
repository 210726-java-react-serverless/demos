package com.revature.bookstore.screens;

import com.revature.bookstore.models.AppUser;
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

        System.out.println("\nLogin to your account!\n");

        System.out.print("Username: ");
        String username = consoleReader.readLine();

        System.out.print("Password: ");
        String password = consoleReader.readLine();

        AppUser authUser = userService.login(username, password);

        if (authUser != null) {
            System.out.printf("Login successful for user: %s!\n", authUser.getUsername());
            router.navigate("/dashboard");
        } else {
            System.out.println("No user found with provided credentials");
        }


    }

}
