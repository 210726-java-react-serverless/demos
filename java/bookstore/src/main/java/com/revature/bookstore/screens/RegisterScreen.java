package com.revature.bookstore.screens;


import com.revature.bookstore.models.AppUser;
import com.revature.bookstore.services.UserService;
import com.revature.bookstore.util.ScreenRouter;

import java.io.BufferedReader;
import java.util.Random;

public class RegisterScreen extends Screen {

    private Random rand = new Random();
    private final UserService userService;
    private int idVal;

    public RegisterScreen(BufferedReader consoleReader, ScreenRouter router, UserService userService) {
        super("RegisterScreen", "/register", consoleReader, router);
        this.userService = userService;
    }

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

        idVal = rand.nextInt(1000);
        AppUser newUser = new AppUser(firstName, lastName, email, username, password, idVal);

        System.out.println(newUser);
        router.navigate("/welcome");

        userService.register(newUser);


    }


}
