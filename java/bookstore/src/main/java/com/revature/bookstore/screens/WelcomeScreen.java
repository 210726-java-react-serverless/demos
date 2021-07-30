package com.revature.bookstore.screens;

import com.revature.bookstore.util.ScreenRouter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WelcomeScreen extends Screen {

    public WelcomeScreen(BufferedReader consoleReader, ScreenRouter router) {
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

//        InputStreamReader consoleInputReader = new InputStreamReader(System.in);
//        BufferedReader consoleReader = new BufferedReader(consoleInputReader);

        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

        try {
            String userSelection = consoleReader.readLine();
            System.out.println(userSelection); // if an exception is thrown this will not be executed

            if(userSelection.equals("2")) {
                Person.Render();
            }if(userSelection.equals("3")){
                System.out.println("Goodbye");
                //consoleReader.close();
            }
            else {
                System.out.println("Page is under construction, but we can register you today");
                //consoleReader.close();
            }
                RegisterScreen register = new RegisterScreen();
                register.render();
                //consoleReader.close();

        } catch (IOException ioe) {
            System.err.println("An IOException was thrown...");
        } //finally {
            //System.out.println("This will run regardless of whether or not an exception is thrown.");

            // TODO clean up this ugly garbage!
            try {
                consoleReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }



    }

