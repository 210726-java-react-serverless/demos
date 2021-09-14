package com.revature.bookstore.screens;

import com.revature.bookstore.Util.ScreenRouter;
import com.revature.bookstore.services.UserService;
import com.revature.bookstore.models.AppUser;

import java.io.BufferedReader;

public class LoginScreen extends Screen {


    private final UserService userService;

    public LoginScreen(BufferedReader consoleReader, ScreenRouter router,UserService userService) {
        super("LoginScreen", "/login", consoleReader, router);
        this.userService = userService;
    }

    @Override
    public void render() throws Exception {
        System.out.println("\n Login Screen");

        System.out.print("Username: ");
        String username = consoleReader.readLine();

        System.out.print("Password: ");
        String password = consoleReader.readLine();

        System.out.println(username + password + "in login screen");
        if (userService.login(username,password) != null)
            router.navigate("/welcome");
        else
            System.out.println("Invalid Credentials");

        }

    }
