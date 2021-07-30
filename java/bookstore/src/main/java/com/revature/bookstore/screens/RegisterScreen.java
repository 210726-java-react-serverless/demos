package com.revature.bookstore.screens;

import com.revature.bookstore.models.AppUser;
import com.revature.bookstore.util.ScreenRouter;
import com.revature.bookstore.services.UserService;

import java.io.BufferedReader;

public class RegisterScreen extends Screen {

    private final UserService userService;

    public RegisterScreen(BufferedReader consoleReader, ScreenRouter r, UserService u) {
        super("RegisterScreen", "/register", consoleReader, r);
        this.userService = u;
    }

    @Override
    public void render() throws Exception {
        System.out.println("Register for a new account!\n");

        System.out.print("First name: ");
        String firstName = consoleReader.readLine();

        System.out.print("Last name: ");
        String lastName = consoleReader.readLine();

        System.out.print("Email: ");
        String email = consoleReader.readLine();

        System.out.print("Username: ");
        String username = consoleReader.readLine();

        System.out.print("Password: ");
        String password = consoleReader.readLine();

        AppUser newUser = new AppUser(firstName, lastName, email, username, password);
        newUser.Set_ID(username.hashCode()); // FIXME: maybe add randomly generated salt

        System.out.println(newUser);
        router.navigate("/welcome");

        userService.Register(newUser);
    }
}