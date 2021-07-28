package com.revature.bookstore.screens;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import com.revature.bookstore.Account;


public class RegisterScreen extends Screen{

    public RegisterScreen() {
        super("RegisterScreen", "/register");
    }

    @Override
    public void render() {

        String un = null;
        String pw = null;
        String fn = null;
        String ln = null;

        System.out.println("Please enter your desired Username:\n" +
                        "> ");
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

        try {
            un = consoleReader.readLine();
        } catch (IOException ioe) {
            System.err.println("Invalid entry!");
        }

        System.out.println("Please enter your desired Password:\n" +
                "> ");

        try {
            pw = consoleReader.readLine();
        } catch (IOException ioe) {
            System.err.println("Invalid entry!");
        }

        System.out.println("Please enter your First Name:\n" +
                "> ");

        try {
            fn = consoleReader.readLine();
        } catch (IOException ioe) {
            System.err.println("Invalid entry!");
        }

        System.out.println("Please enter your Last Name:\n" +
                "> ");

        try {
            ln = consoleReader.readLine();
        } catch (IOException ioe) {
            System.err.println("Invalid entry!");
        } finally{
            try {
                consoleReader.close();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }

        if(un.equals(null)||pw.equals(null)||fn.equals(null)||ln.equals(null))
        {
            System.out.println("Invalid data detected, please try again.");
        }
        else
        {
            Account init= new Account(un,pw,fn,ln);
            System.out.println("Username: " + init.getUsername() +
                    "\nPassword: " + init.getPassword() +
                    "\nFire Name: " + init.getFirstname() + // did you catch it?
                    "\nLast Name: " + init.getLastname());
        }


    }


}
