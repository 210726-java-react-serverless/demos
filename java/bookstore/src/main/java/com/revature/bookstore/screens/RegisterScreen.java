package com.revature.bookstore.screens;

import java.io.BufferedReader;

public class RegisterScreen extends Screen{

    public RegisterScreen(BufferedReader consoleReader, ScreenRouter router) {
        super("RegisterScreen", "/register", consoleReader, router);
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

        System.out.println(newUser);
        router.navigate("/welcome");

        // TODO validate that provided information is correct
        // TODO persist new user to some data source

