package com.revature.bookstore.screens;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LoginScreen extends Screen{

    public LoginScreen() {
        super("LoginScreen", "/login");
    }


    @Override
    public void render() {

        String un = null;
        String pw = null;

        System.out.println("Please enter your username:\n" +
                "> ");

        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

        try {
            un = consoleReader.readLine();
        } catch (IOException ioe) {
            System.err.println("Invalid entry!");
        }

        System.out.println("Please enter your password:\n" +
                "> ");

        try {
            pw = consoleReader.readLine();
        } catch (IOException ioe) {
            System.err.println("Invalid entry!");
        } finally {
            try {
                consoleReader.close();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }

        System.out.println("Your username is: " + un +
                "\nYour password is: " + pw);



    }
}
