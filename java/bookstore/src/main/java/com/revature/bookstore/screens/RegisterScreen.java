package com.revature.bookstore.screens;
import java.io.IOException;
import com.revature.bookstore.model.User;

public class RegisterScreen extends Screen {

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
        String username;
        String password;
        String firstname;
        String lastname;

        User user = null; // this null case should never be used
        do {
        username = repeated_ask("Input username> ");
        user = database.findUser(username);
        if (user != null) System.out.println("Username already taken.");}
        while (user != null);

        String password_validated = null;
        do {
            password = repeated_ask("Input password> ");
            password_validated = repeated_ask("Input password again");
            if (!password_validated.equals(password)) System.out.println("Passwords don't match.");
        } while (!password_validated.equals(password));

        firstname = repeated_ask("Input first name> ");
        lastname = repeated_ask("Input last name> ");
        String confirm = repeated_ask("above is all right? [Y/n]");
        if (confirm.equals("n")) render();

        database.addUser(new User(username,password,firstname,lastname));
    }
    public void test() {database.addUser(
            new User("username","password","firstname","lastname"));
    }
}
