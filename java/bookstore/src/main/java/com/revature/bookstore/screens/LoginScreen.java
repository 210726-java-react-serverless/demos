package com.revature.bookstore.screens;


import com.revature.bookstore.repositories.UserRepository;
import com.revature.bookstore.util.ScreenRouter;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
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
        UserRepository repo = new UserRepository();
            while(true) {
                System.out.print("Enter your username, or type 'exit' to exit: ");
                loginUsername = consoleReader.readLine();
                if(loginUsername.equals("exit"))
                    break;
                System.out.print("Enter your password: ");
                loginPassword = consoleReader.readLine();
                if (repo.search(this)) {
                    System.out.println("Login successful!");
                    break;
                } else{
                    System.out.println("Invalid username or password. Please try again, or type 'exit'");
                }

            }
                router.navigate("/welcome");

            }

    public String getLoginUsername() {
        return loginUsername;
    }

    public String getLoginPassword() {
        return loginPassword;
    }
}



