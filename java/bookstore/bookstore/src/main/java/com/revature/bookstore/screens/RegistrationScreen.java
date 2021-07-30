package com.revature.bookstore.screens;
import com.revature.bookstore.Util.ScreenRouter;
import java.io.*;
import java.nio.file.Path;

public class RegistrationScreen extends Screen {
    private String username;
    private String password;
    public RegistrationScreen(BufferedReader consoleReader,ScreenRouter router) {
        super("Registration", "route: /registration", consoleReader,router);
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void render() {
        String usernameInput = "You are on the registration screen.\n" +
                "Enter a username: \n" +
                ">";
        String passwordInput = "Now, enter a password: \n" +
                ">";
        try (
                BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        ) {
            System.out.print(usernameInput);
            String username = consoleReader.readLine();
            System.out.print(passwordInput);
            String password = consoleReader.readLine();
             setUsername(username); //could have used a setter
             setPassword(password);
        } catch (IOException ioe) {
            System.err.println("You entered an invalid username.");

        }
        try (
                BufferedWriter bw = new BufferedWriter(new FileWriter("registrationInfo.txt"));
        ) {
            bw.write(username + "\n" + password);
        } catch (IOException e) {
            System.err.print("Could not write username and/or password to file");
        }
    }

}