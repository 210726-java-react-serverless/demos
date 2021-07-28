package com.revature.bookstore.screens;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.*;
import java.sql.SQLOutput;

public class RegisterScreen extends Screen {

    Screen parent;
    public RegisterScreen(Screen parentScreen){
        super("RegisterScreen", "/register");
        this.parent = parentScreen;
    }


    @Override
    public void render() {

        String menu = "\nEnter your registration details\n";
        System.out.print(menu);

        System.out.print("Enter username: ");
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

        String username = "", password = "", firstname = "", lastname = "";

        try {
            username = consoleReader.readLine();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        System.out.print("Enter password: ");
        try {
            password = consoleReader.readLine();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        System.out.print("Enter first name: ");
        try {
            firstname = consoleReader.readLine();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        System.out.print("Enter last name: ");
        try {
            lastname = consoleReader.readLine();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        System.out.println("You have completed registration");

        FileOutputStream fos = null;
        try{
            File file = new File("./registrationDetails.txt");
            fos = new FileOutputStream(file);
            System.out.println("Created successfully "+ file.getAbsolutePath());

            String output = username + "\n" + password + "\n" + firstname + "\n" + lastname;
            char[] charArr = output.toCharArray();
            for(char c : charArr){
                fos.write(c);
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            try {
                if(fos != null){
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        System.out.print("Press '1' to return: ");
        try{
            String userSelection = consoleReader.readLine();

            if(userSelection.equals("1")){
                parent.render();
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }









    }
}
