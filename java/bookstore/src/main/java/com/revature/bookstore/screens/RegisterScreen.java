package com.revature.bookstore.screens;
import java.io.IOException;
import com.revature.bookstore.model.User;

public class RegisterScreen extends Screen {
    private String username;
    // char[] password; // more secure alternative
    private String password;
    private String firstname;
    private String lastname;

    public RegisterScreen() {
        super("RegisterScreen", "/Register");
    }

    private String repeated_ask(String ask_string) {

        do {
            try {
                System.out.println(ask_string);
                return consoleReader.readLine().trim();
            }
            catch (IOException ioe) {System.out.println("Try again.");}
        }
        while (true);

    }
    public void render() {
        username = repeated_ask("Input username> ");
        password = repeated_ask("Input password> ");
        // password_validated = repeated_ask("Input password again");
        firstname = repeated_ask("Input first name> ");
        lastname = repeated_ask("Input last name> ");
        // User user = new User(username, password, firstname, lastname);
    }

    public void close() {

    }
}
