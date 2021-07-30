package com.revature.bookstore.screens;

import com.revature.bookstore.models.AppUser;
import com.revature.bookstore.services.UserService;
import com.revature.bookstore.util.ScreenRouter;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;


import java.io.BufferedReader;

public class RegisterScreen extends Screen {

    private final UserService userService;
    private final Logger logger = LogManager.getLogger(this.getClass());

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

        AppUser newUser = new AppUser(firstName, lastName, email, username, password);

        try {
            logger.trace("Attempting to make new user");
            userService.register(newUser);
            logger.trace("User successfully registered!");
            router.navigate("/dashboard");
        } catch (Exception e) {
            logger.error("User was not registered");
            router.navigate("/welcome");
        }

    }

}
