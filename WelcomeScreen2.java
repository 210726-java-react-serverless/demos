package src.main.java.com.revature.bookstore.screens;

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

//        InputStreamReader consoleInputReader = new InputStreamReader(System.in);
//        BufferedReader consoleReader = new BufferedReader(consoleInputReader);

        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

        try {
            String userSelection = consoleReader.readLine();
            switch (userSelection)
            {
                case "1":
                    System.out.println("Enter Login");
                    String lg = userSelection;
                    //RegisterScreen newScreen = new RegisterScreen();
                    //newScreen.render();
                    break;

                case "3":
                    System.out.println("You pick option 3)");
                    //Quit App
                    break;

            }
            //quit program

            
            System.out.println(userSelection); // if an exception is thrown this will not be executed
        } catch (IOException ioe) {
            System.err.println("An IOException was thrown...");
        } finally {
            System.out.println("This will run regardless of whether or not an exception is thrown.");

            // TODO clean up this ugly garbage!
            try {
                consoleReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }



    }
}
