package com.revature.bookstore.screens;

import com.sun.org.apache.xpath.internal.operations.Bool;
import jdk.internal.util.xml.impl.Input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WelcomeScreen extends Screen{

    public WelcomeScreen(){
        super("Welcome Screen", "/welcome");
    }

    @Override
    public void render() throws Exception {
        String menu = "\nWelcome to RevaBooks!\n"+
                "1. Login\n" +
                "2. Register\n" +
                "3. Exit Application\n" +
                "> ";
        System.out.println(menu);

        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

        try{
            String userSelection = consoleReader.readLine();
            System.out.println(userSelection);

        }catch (IOException ioe){
            System.out.println("IO Exception\n");
        } finally{
            //System.out.println("This will run regardless of whether or not an exception is thrown\n");
        }

        boolean check = false;
        int consoleReaderInt = Integer.parseInt(consoleReader.readLine());
        //int consoleReaderInt = 1;


        BufferedReader username = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader password = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader firstName = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader lastName = new BufferedReader(new InputStreamReader(System.in));

        BufferedReader logusername = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader logpassword = new BufferedReader(new InputStreamReader(System.in));



        while(check != true){
            if(consoleReaderInt == 1){
                System.out.println("\nLogin Screen Not Yet Implemented");

                check = true;
            }
            else if(consoleReaderInt == 2){
                System.out.println("\nEnter new Username: ");
                String usernameSelection = username.readLine();
                System.out.println("\nEnter new Password: ");
                String passwordSelection = password.readLine();
                RegisterScreen reg = new RegisterScreen(usernameSelection, passwordSelection);
                reg.setUsername(usernameSelection);
                reg.setPassword(passwordSelection);

                System.out.println("\nEnter First Name: ");
                String firstNameSelection = firstName.readLine();
                System.out.println("\nEnter Last Name: ");
                String lastNameSelection = lastName.readLine();
                reg.setFirstName(firstNameSelection);
                reg.setLastName(lastNameSelection);

                check = true;
            }
            else if(consoleReaderInt == 3){

                check = true;
            }
            else{
                System.out.println("Incorrect Input\n");
                consoleReaderInt = 1;
            }

        }



    }
}
