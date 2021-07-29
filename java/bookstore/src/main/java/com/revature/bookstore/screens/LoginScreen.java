package com.revature.bookstore.screens;

import com.revature.bookstore.repositories.UserRepository;
import com.revature.bookstore.util.ScreenRouter;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class LoginScreen extends Screen {

    public LoginScreen(BufferedReader consoleReader, ScreenRouter router) {
        super("LoginScreen", "/login", consoleReader, router);
    }

    @Override
    public void render() throws Exception {
        UserRepository repo = new UserRepository();
        try{
            BufferedReader stream  = new BufferedReader(new InputStreamReader(System.in));
            while(true) {
                System.out.print("Enter your username, or type 'exit' to exit: ");
                String username = stream.readLine();
                if(username.equals("exit"))
                    break;
                System.out.print("Enter your password: ");
                String password = stream.readLine();
                if (repo.findByName(username, password)) {
                    System.out.println("Login successful!");
                    break;
                } else{
                    System.out.println("Invalid username or password. Please try again, or type 'exit'");

                }

            }
                router.navigate("/welcome");
            } finally{

            }

    }

}
