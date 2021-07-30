package com.revature.bookstore.screens;


import com.revature.bookstore.util.ScreenRouter;
import com.sun.org.apache.xpath.internal.operations.Bool;
import jdk.internal.util.xml.impl.Input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class WelcomeScreen extends Screen {

    public WelcomeScreen(BufferedReader consoleReader, ScreenRouter router) {
        super("WelcomeScreen", "/welcome", consoleReader, router);
        System.out.println("WelcomeScreen instantiated!");

    }

    @Override
    public void render() throws Exception {

        String menu = "\nWelcome to RevaBooks!\n"+
                "1. Login\n" +
                "2. Register\n" +
                "3. Exit Application\n" +
                "> ";
        System.out.print(menu);

        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

        String userSelection = consoleReader.readLine();

        switch (userSelection) {

            case "1":
                router.navigate("/login");
                break;
            case "2":
                router.navigate("/register");
                break;
            case "3":
                System.out.println("Exiting application...");
                // figure a way to make the app shutdown
                // TODO this is ugly and bad practice, we will fix it later
                System.exit(0);
            default:
                System.out.println("You provided an invalid value, please try again.");


        }



    }
}
