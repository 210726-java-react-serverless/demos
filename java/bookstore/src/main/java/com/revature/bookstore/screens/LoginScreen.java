package com.revature.bookstore.screens;

import com.revature.bookstore.util.ScreenRouter;

import java.io.BufferedReader;
import java.io.File;
import java.util.Scanner;

public class LoginScreen extends Screen {

    public LoginScreen(BufferedReader consoleReader, ScreenRouter router) {
        super("LoginScreen", "/login", consoleReader, router);
    }

    // ID:Firstname:Lastname:Email:Username:Password

    @Override
    public void render() throws Exception {
        System.out.println("LoginScreen works!");
        System.out.println("Screen under construction, sending you back to the Welcome Screen.");

        System.out.println("Enter your Username and Password below.");
        System.out.print("Username: ");
        String username = consoleReader.readLine();
        System.out.print("Password: ");
        String password = consoleReader.readLine();

        File data = new File("src/main/resources/data.txt");
        Scanner scan = new Scanner(data);
        String line = "";
        String scanUsername = "";
        String scanPassword = "";

        boolean isLoggingIn = false;

        // Scan over data source for matching username/password to credentials entered
        // by user.
        while(scan.hasNextLine()) {
            line = scan.nextLine();
            scanUsername = line.split(":")[4];
            scanPassword = line.split(":")[5];

//            System.out.println("Test Scanned Username: " + scanUsername);
//            System.out.println("Test Scanned Password: " + scanPassword);

            if(scanUsername.equals(username)) {
                if(scanPassword.equals(password)) {
                    System.out.println("\nSuccess! Logging you in...\n");
                    isLoggingIn = true;
                    router.navigate("/welcome");
                    return;
                } else {
                    // TODO make outer control loop, don't re-create page.
                    System.out.println("\nIncorrect Password.\n");
                    router.navigate("/login");
                    return;
                }
            }

            // No User found
            if(!scan.hasNextLine()) {
                System.out.println("\nNo User Found.\n");
            }
        }

        router.navigate("/welcome");
    }

}
