package com.revature.bookstore.screens;

import com.revature.bookstore.models.AppUser;
import com.revature.bookstore.services.UserService;
import com.revature.bookstore.util.ScreenRouter;

import java.io.BufferedReader;

public class LoginScreen extends Screen {
    private UserService userService;

    public LoginScreen(BufferedReader consoleReader, ScreenRouter router, UserService userService) {
        super("login", "/login", consoleReader, router);
        this.userService = userService;
    }

    @Override
    public void render() throws Exception{
        System.out.println("Enter Username: \n" + ">\n");
        String username = consoleReader.readLine();

        System.out.println("Enter Password: \n" + ">\n");
        String password = consoleReader.readLine();

        AppUser user = userService.login(username, password);
        System.out.println(user);

        router.navigate("/dash");

    }
}
