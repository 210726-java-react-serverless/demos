package com.revature.bookstore.screens;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WelcomeScreen extends Screen{

    private String userSelection;

    public WelcomeScreen() {
        super("WelcomeScreen", "/welcome");
    }

    public String getUserSelection() {
        return userSelection;
    }

    @Override
    public void render() {

        String menu = "\nWelcome to RevaBooks!\n" +
                      "1) Login\n" +
                      "2) Register\n" +
                      "3) Exit Application\n" +
                      "> ";

        System.out.println(menu);

        InputStreamReader consoleInputReader = new InputStreamReader(System.in);
        BufferedReader consoleReader = new BufferedReader(consoleInputReader);

        try {
            userSelection = consoleReader.readLine();


//            RegisterScreen registerScreen = new RegisterScreen();
//            registerScreen.render();
//            System.out.println(userSelection);  // if an exception is thrown, this will not be executed
        } catch(IOException ioe) {
            System.err.println("An IOException was thrown...");
        }  // catch(NullPointerException npe) { }
        finally {
            System.out.println("This will run regardless of whether or not an exception is thrown.");
//            consoleReader.close();
        }


    }

}
