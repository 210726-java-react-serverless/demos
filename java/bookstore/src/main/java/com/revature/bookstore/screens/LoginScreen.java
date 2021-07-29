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
        System.out.print("LoginScreen works!");

        System.out.print("Enter username \n> ");
        String username = consoleReader.readLine();

        System.out.print("Enter password \n> ");
        String password = consoleReader.readLine();

        System.out.println(userService.login(username, password));

        router.navigate("/dashboard");
    }

}
