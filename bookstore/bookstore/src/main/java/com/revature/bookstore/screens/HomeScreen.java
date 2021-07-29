package com.revature.bookstore.screens;

import com.revature.bookstore.util.ScreenRouter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HomeScreen extends Screen {

    public HomeScreen(BufferedReader consoleReader, ScreenRouter router) {
        super("home", "/home", consoleReader, router);
    }

    @Override
    public void render() throws Exception{
        //Do code
        String menu = "\nWelcome to RevaBooks!\n" +
                      "1) Login\n" +
                      "2) Register\n" +
                      "3) Exit application\n" +
                      "> ";

        System.out.print(menu);

        try {
            String userSelection = consoleReader.readLine();
            switch (userSelection) {
                case "1":
                    router.navigate("/login");
                    break;
                case "2":
                    router.navigate("/register");
                    break;
                case "3":
                    //TODO: FIX THIS
                    System.out.println("Exiting app");
                    System.exit(0);
                default:
                    System.out.println("Invalid input");
            }

        } catch(IOException e) {
            System.err.println("OH NO! Error: " + e + "\n");
        }

    }
}
