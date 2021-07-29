package com.revature.bookstore.screens;

import com.revature.bookstore.util.ScreenRouter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WelcomeScreen extends Screen{

    private String userSelection;

    public WelcomeScreen(BufferedReader consoleReader, ScreenRouter router) {
        super("WelcomeScreen", "/welcome", consoleReader, router);
        System.out.println("WelcomeScreen instantiated!");
    }

    public String getUserSelection() {
        return userSelection;
    }

    @Override
    public void render() throws Exception {

        String menu = "\nWelcome to RevaBooks!\n" +
                      "1) Login\n" +
                      "2) Register\n" +
                      "3) Exit Application\n" +
                      "> ";

        System.out.println(menu);


        userSelection = consoleReader.readLine();

        switch (userSelection) {
            case "1":
                router.navigate("/login");
                break;
            case "2":
                router.navigate("/register");
                break;
            case "3":
                System.out.println("Exiting application...");
                // TODO this is ugly and bad practice, we will fix it later
                System.exit(0);
            default:
                System.out.println("You provided an invalid value, please try again.");
        }


    }

}
