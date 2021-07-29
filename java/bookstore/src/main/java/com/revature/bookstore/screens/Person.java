package com.revature.bookstore.screens;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Person {



    public static void Render() throws IOException {
        String lastname;
        String firstname;
        String username;
        String password;

        System.out.println("Lets get you registered");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter your last name: ");
        try {
             lastname = reader.readLine();
        } catch (IOException ioe) {
            if (lastname == null) {
                System.out.println("Exception raised");
                //commented out StackTraces because of lengthy outputs
                //ioe.printStackTrace();
            }if (lastname != null){
                reader.close();
            }
        }

        System.out.println("Enter your first name: ");
        try {
             firstname = reader.readLine();
        }
        if (firstname == null) {
        catch(IOException ioe){
                System.out.println("Exception raised");
                //ioe.printStackTrace();
            }if (firstname != null){
            reader.close();
            }
        }

        System.out.println("Enter your user name: ");
        try {
            String username = reader.readLine();
        }

        catch (IOException ioe) {
            if (username == null) {
                System.out.println("Exception raised");
                //ioe.printStackTrace();
            }if (username != null){
                reader.close();
            }
        }

        System.out.println("Enter your password: ");
        try {
            String password = reader.readLine();
        } catch (IOException ioe) {
            if (password == null) {
                System.out.println("Exception raised");
                //ioe.printStackTrace();
            } if (password != null){
                reader.close();
            }
        }

        





    }
}
