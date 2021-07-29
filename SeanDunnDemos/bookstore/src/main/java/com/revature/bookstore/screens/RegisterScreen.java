package com.revature.bookstore.screens;

import com.revature.bookstore.models.AppUser;
import com.revature.bookstore.services.UserService;
import com.revature.bookstore.util.ScreenRouter;

import java.io.*;

public class RegisterScreen extends Screen{

    private final UserService userService;
    private int iterator;

    public RegisterScreen(BufferedReader consoleReader, ScreenRouter router, UserService userService) {
        super("RegisterScreen", "/register", consoleReader, router);
        this.userService = userService;
        iterator = 1;
    }

    /*
        S in SOLID: Single Dependency - one purpose for each function.
        If the render function also validated info and sent data to a new source,
        harder to manage, harder to debug.
     */

    @Override
    public void render() throws Exception {

        System.out.println("\nRegister for a new account!");
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

        userService.register(newUser, iterator);


        System.out.println(newUser);
        iterator++;

        router.navigate("/welcome");
    }
}
