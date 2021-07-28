package com.revature.bookstore.screens;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HomeScreen extends Screen {

    public HomeScreen() {
        super("WelcomeScreen", "/welcome");
    }

    @Override
    public void render() {
        //Do code
        String menu = "\nWelcome to RevaBooks!\n" +
                      "1) Login\n" +
                      "2) Register\n" +
                      "3) Exit application\n" +
                      "> ";

        System.out.print(menu);
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

        try {
            String userSelection = consoleReader.readLine();
            System.out.println(userSelection);

            if(userSelection.equals("Register")) {
                RegisterScreen regScreen = new RegisterScreen();
                regScreen.render();
            } else {
                System.out.println("Enter a valid option");
                return;
            }
        } catch(IOException e) {
            System.err.println("OH NO! Error: " + e + "\n");
        }
    }
}
