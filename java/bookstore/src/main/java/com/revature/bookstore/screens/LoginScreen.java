package com.revature.bookstore.screens;

import com.revature.bookstore.util.ScreenRouter;
import com.revature.bookstore.services.UserService;

import java.io.BufferedReader;

public class LoginScreen extends Screen {

    private final UserService service;

    public LoginScreen(BufferedReader consoleReader, ScreenRouter r, UserService u) {
        super("LoginScreen", "/login", consoleReader, r);
        service = u;
    }

    @Override
    public void render() throws Exception {
        System.out.print("Username: ");
        String name = consoleReader.readLine();

        System.out.print("Password: ");
        String pw = consoleReader.readLine();

        service.Login(name, pw);

        router.navigate("/welcome");
    }

}
