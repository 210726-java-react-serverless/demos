package com.revature.bookstore.screens;


import com.revature.bookstore.repositories.UserRepository;
import com.revature.bookstore.util.ScreenRouter;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class LoginScreen extends Screen{


    public LoginScreen(String name, String route) {
        super(name, route);
    }

    private String loginUsername;
    private String loginPassword;


    public LoginScreen(BufferedReader consoleReader, ScreenRouter router) {
        super("LoginScreen", "/login", consoleReader, router);
    }

    @Override
    public void render() throws Exception {
        UserRepository repo = new UserRepository(); //see the authenticate() method in the UserRepo class definition

            /* User inputs username and password, both are passed to the authenticate method. Passed in an
             unending while loop that only breaks if you enter valid credentials, or you type 'exit' for the username.
             */
            while(true) {
                System.out.print("Enter your username, or type 'exit' to exit: ");
                loginUsername = consoleReader.readLine();
                if(loginUsername.equals("exit"))
                    break;
                System.out.print("Enter your password: ");
                String loginPassword = consoleReader.readLine();
                if (repo.authenticate(loginUsername, loginPassword)) {
                    System.out.println("Login successful!");
                    break;
                } else{
                    System.out.println("Invalid username or password. Please try again, or type 'exit'");
                }

            }
                router.navigate("/welcome");

            }

}



