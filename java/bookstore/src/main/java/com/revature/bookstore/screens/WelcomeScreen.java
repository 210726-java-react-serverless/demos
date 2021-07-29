package com.revature.bookstore.screens;

import com.revature.bookstore.util.ScreenRouter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WelcomeScreen extends Screen {

    public WelcomeScreen(BufferedReader consoleReader, ScreenRouter router) {
        super("WelcomeScreen", "/welcome", consoleReader, router);
    }

    @Override
    public void render() throws Exception {

        String menu = "\nWelcome to RevaBooks!\n" +
                      "1) Login\n" +
                      "2) Register\n" +
                      "3) Exit application\n" +
                      "> ";

        System.out.print(menu);

        String userInput = consoleReader.readLine();
        switch(userInput){
            case "1":
                //login
                break;
            case "2":
                router.navigate("/register");
                break;
            case "3":
                System.out.println("Exiting application");
                System.exit(0);
            default:
                System.out.println("Input was invalid");
        }

    }
}
