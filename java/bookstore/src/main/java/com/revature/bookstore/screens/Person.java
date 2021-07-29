package com.revature.bookstore.screens;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Person {
    String lastname;
    String firstname;
    String username;
    String password;

// portions of below code inspired by Tutorialspoint and W3 articles that I read

    Person(){
        //this.lastname = LN;
        //this.firstname = FN;
        //this.username = UN;
        //this.password = PW;
    }


    public static void Render() throws IOException {
        System.out.println("Lets get you registered");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter your last name: ");
        try {
            String lastname = reader.readLine();
        } catch (IOException ioe){
            System.out.println("Exception raised");
            ioe.printStackTrace();
        }

        System.out.println("Enter your first name: ");
        try {
            String firstname = reader.readLine();
        } catch (IOException ioe){
            System.out.println("Exception raised");
            ioe.printStackTrace();
        }

        System.out.println("Enter your user name: ");
        try {
            String username = reader.readLine();
        } catch (IOException ioe){
            System.out.println("Exception raised");
            ioe.printStackTrace();
        }

        System.out.println("Enter your password: ");
        try {
            String password = reader.readLine();
        } catch (IOException ioe){
            System.out.println("Exception raised");
            ioe.printStackTrace();
        }

        reader.close();

        //ArrayList<String> registrant = new ArrayList<String>();
        //registrant.add(lastname);
        //registrant.add(firstname);
        //registrant.add(username);
        //registrant.add(password);

        //System.out.println(registrant);




    }
}
