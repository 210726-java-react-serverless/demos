package com.revature.bookstore.screens;

import com.revature.bookstore.exceptions.InvalidRequestException;
import com.revature.bookstore.models.AppUser;
import com.revature.bookstore.services.UserService;
import com.revature.bookstore.util.ScreenRouter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.io.*;

public class RegisterScreen extends Screen{
    private UserService userService;
    private final Logger logger = LogManager.getLogger(RegisterScreen.class);

    public RegisterScreen(BufferedReader consoleReader, ScreenRouter router, UserService userService ) {
        super("register", "/register", consoleReader, router);
        this.userService = userService;
    }

    @Override
    public void render() throws Exception{
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter First Name: \n" + ">\n");
        String firstName = consoleReader.readLine();

        System.out.println("Enter Last Name: \n" + ">\n");
        String lastName = consoleReader.readLine();

        System.out.println("Enter Email: \n" + ">\n");
        String email = consoleReader.readLine();

        System.out.println("Enter Username: \n" + ">\n");
        String username = consoleReader.readLine();

        System.out.println("Enter Password: \n" + ">\n");
        String password = consoleReader.readLine();

        AppUser newUser = new AppUser(firstName, lastName, email, username, password);

        try {
            userService.register(newUser);
            router.navigate("/dash");
            logger.info("New user created!\n" + newUser.toString());
        } catch(Exception e) {
            logger.error("Invalid credentials");
            router.navigate("/register");
        }

    }
}
