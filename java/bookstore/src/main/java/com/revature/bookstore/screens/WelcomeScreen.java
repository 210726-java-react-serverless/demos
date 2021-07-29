package com.revature.bookstore.screens;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WelcomeScreen extends Screen {

    public WelcomeScreen(BufferedReader consoleReader) {
        super("WelcomeScreen", "/welcome", consoleReader);
    }

    @Override
    public void render() {

        String menu = "\nWelcome to RevaBooks!\n" +
                      "1) Login\n" +
                      "2) Register\n" +
                      "3) Exit application\n" +
                      "> ";

        System.out.print(menu);

        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

        try {
            String userSelection = consoleReader.readLine();
            System.out.println(userSelection); // if an exception is thrown this will not be executed
        } catch (IOException ioe) {
            System.err.println("An IOException was thrown...");
        }

    }
}
