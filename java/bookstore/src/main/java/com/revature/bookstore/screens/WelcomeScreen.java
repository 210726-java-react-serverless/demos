package com.revature.bookstore.screens;

import com.revature.bookstore.util.ScreenRouter;

import java.io.BufferedReader;

public class WelcomeScreen extends Screen {

    public WelcomeScreen(BufferedReader consoleReader, ScreenRouter router) {
        super("WelcomeScreen", "/welcome", consoleReader, router);
<<<<<<< HEAD
=======
        System.out.println("WelcomeScreen instantiated!");
>>>>>>> 846980801a1c42168f47cf961a68229b941ed89f
    }

    @Override
    public void render() throws Exception {

        String menu = "\nWelcome to RevaBooks!\n" +
                      "1) Login\n" +
                      "2) Register\n" +
                      "3) Exit application\n" +
                      "> ";

        System.out.print(menu);

<<<<<<< HEAD
        String userInput = consoleReader.readLine();
        switch(userInput){
            case "1":
                //login
=======
        String userSelection = consoleReader.readLine();

        switch (userSelection) {

            case "1":
                router.navigate("/login");
>>>>>>> 846980801a1c42168f47cf961a68229b941ed89f
                break;
            case "2":
                router.navigate("/register");
                break;
            case "3":
<<<<<<< HEAD
                System.out.println("Exiting application");
                System.exit(0);
            default:
                System.out.println("Input was invalid");
=======
                System.out.println("Exiting application...");
                // figure a way to make the app shutdown
                // TODO this is ugly and bad practice, we will fix it later
                System.exit(0);
            default:
                System.out.println("You provided an invalid value, please try again.");

>>>>>>> 846980801a1c42168f47cf961a68229b941ed89f
        }



    }
}
