package com.revature.bookstore.screens;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Person {



    public static void Render() throws IOException {
        System.out.println("Lets get you registered");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter your last name: ");
        try {
            String lastname = reader.readLine();
        } catch (IOException ioe){
            System.out.println("Exception raised");
            //commented out StackTraces because of lengthy outputs
            //ioe.printStackTrace();
        }

        System.out.println("Enter your first name: ");
        try {
            String firstname = reader.readLine();
        } catch (IOException ioe){
            System.out.println("Exception raised");
            //ioe.printStackTrace();
        }

        System.out.println("Enter your user name: ");
        try {
            String username = reader.readLine();
        } catch (IOException ioe){
            System.out.println("Exception raised");
            //ioe.printStackTrace();
        }

        System.out.println("Enter your password: ");
        try {
            String password = reader.readLine();
        } catch (IOException ioe){
            System.out.println("Exception raised");
            //ioe.printStackTrace();
        }

        reader.close();





    }
}
