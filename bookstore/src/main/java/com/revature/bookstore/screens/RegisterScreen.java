package com.revature.bookstore.screens;

import java.io.*;

public class RegisterScreen extends Screen{

    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

    public RegisterScreen() {
        super("RegisterScreen", "/register");
        username = "Default";
        password = "password";
        firstname = "name1";
        lastname = "name2";
    }

    @Override
    public void render(){

        // Get user input from console and append info to file
        username = tryParsing("Enter username: ");
        userToFile(username);
        password = tryParsing("Enter password: ");
        userToFile(password);
        firstname = tryParsing("Enter first name: ");
        userToFile(firstname);
        lastname = tryParsing("Enter last name: ");
        userToFile(lastname);


        closeReader();
    }



    public String tryParsing(String question) {
        System.out.println(question);
        String answer = "Nothing Entered";
        try {
            answer = consoleReader.readLine();
            answer = answer.concat("\n");
//            System.out.println(userSelection);  // if an exception is thrown, this will not be executed
        } catch(IOException ioe) {
            System.err.println("An IOException was thrown...");
        }  // catch(NullPointerException npe) { }
        finally {
            System.out.println("\n");
        }
        return answer;
    }

    public void userToFile(String textLine) {
        try {
            FileWriter write = new FileWriter("example.txt", true);
            PrintWriter print_line = new PrintWriter(write);
            print_line.printf("%s", textLine);
            print_line.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void closeReader() {
        try {
            consoleReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
