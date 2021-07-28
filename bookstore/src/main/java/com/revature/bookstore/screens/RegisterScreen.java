package com.revature.bookstore.screens;

import java.io.*;

public class RegisterScreen extends Screen{
    public RegisterScreen() {
        super("Register", "/register");
    }

    @Override
    public void render() {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

        String prompt = "Enter First Name: \n" + ">\n";
        System.out.println(prompt);
        String firstName = "";
        try {
            firstName = consoleReader.readLine();
            //validation
        } catch(IOException e) {
            System.err.println("OH NO! Error: " + e + "\n");
            e.printStackTrace();
        }

        prompt = "Enter Last Name: \n" + ">\n";
        System.out.println(prompt);
        String lastName = "";
        try {
            lastName = consoleReader.readLine();
            //validation
        } catch(IOException e) {
            System.err.println("OH NO! Error: " + e + "\n");
            e.printStackTrace();
        }

        prompt = "Enter Username: \n" + ">\n";
        System.out.println(prompt);
        String username = "";
        try {
            username = consoleReader.readLine();
            //validation
        } catch(IOException e) {
            System.err.println("OH NO! Error: " + e + "\n");
            e.printStackTrace();
        }

        prompt = "Enter Password: \n" + ">\n";
        System.out.println(prompt);

        String password = "";
        try {
            password = consoleReader.readLine();
            //validation
        } catch(IOException e) {
            System.err.println("OH NO! Error: " + e + "\n");
            e.printStackTrace();
        }

        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter("storage.txt", true));
            //FileWriter writer = new FileWriter("storage.txt");
            writer.write(firstName + " " + lastName + " " + username + " " + password + "\n");
            writer.close();
        } catch(IOException e) {
            System.err.println("OH NO! Error: " + e + "\n");
            e.printStackTrace();
        }



    }
}
