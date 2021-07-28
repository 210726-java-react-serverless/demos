package com.revature.bookstore.screens;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WelcomeScreen extends Screen {

    public WelcomeScreen() {
        super("WelcomeScreen", "/welcome");
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

        int validatedUserInput = -1;

        try {
            String userSelection = consoleReader.readLine();
            System.out.println(userSelection); // if an exception is thrown this will not be executed
            validatedUserInput = Integer.parseInt(userSelection);
        } catch (IOException ioe) {
            System.err.println("An IOException was thrown...");
        }

        switch(validatedUserInput){
            case 1:
                System.out.println("this character hasn't been unlocked yet");
                break;
            case 2:
                RegisterScreen rs = new RegisterScreen();
                try {
                    rs.render();
                } catch (IOException e) {
                    System.out.println("There was an IO Exception in Render()");
                }
                break;
            case 3:
                System.out.println("Thank you for using our app");
                return;
            default:
                System.out.println("You need to input a correct value.");
                this.render();
        }
    }
}
