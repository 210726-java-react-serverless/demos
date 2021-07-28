package com.revature.bookstore.screens;

import com.revature.bookstore.users.UserChecker;
import java.io.*;

public class RegisterScreen extends Screen {

    public RegisterScreen() {
        super("RegisterScreen", "/register");
    }

    @Override
    public void render() {

        String username = null;
        String password = null;

        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.println("\nPlease enter your Username:\n");
            username = consoleReader.readLine();
            System.out.println("\nThen, enter your Password:\n");
            password = consoleReader.readLine();
        } catch (IOException ioe) {
            System.out.println("An IO Exception has occurred!");
        } finally {
            try {
                consoleReader.close();
            } catch (IOException ioe) {
                System.out.println("An IO Exception has occurred in relation to closing the Console Reader!");
            }
        }

        UserChecker uc = new UserChecker();

        try {
            uc.setUserName(username);
            uc.setPassWord(password);
        } catch(NullPointerException npe) {
            System.out.println("Not entering a value is invalid.");
        }
    }
}
