package com.revature.bookstore.screens;


import java.io.*;/*
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
*/

public class RegisterScreen extends Screen {

    private String username;
    private String password; // storing password as plaintext because we suck

    public RegisterScreen() {
        super("RegisterScreen", "/register");
        username = password = "";
    }

    public RegisterScreen(BufferedReader consoleReader) {
        super("RegisterScreen", "/register");

    }

    @Override
    public void render() {
        System.out.println("\nEnter desired username (must have at least 5 characters\n");
        Add_Username();

        try {
            Add_Password();
            Write_File();
        } catch (IOException e) {
            System.out.println("Error with file, sad.");
            e.printStackTrace();
        }
    }

    private void Add_Username() {
        Read_Username();

        while (username.length() < 5) {
            System.err.println("Username is too short\n");
            Read_Username();
        }

        for (int i = 0; i < username.length(); i++) {
            if (!Character.isLetterOrDigit(username.charAt(i))) {
                System.err.println("Invalid character");
                Read_Username();
            }
        }

        // FIXME: check if username is taken
    }

    private void Read_Username() {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

        try {
            username = consoleReader.readLine();
            consoleReader.close();
        } catch (IOException e) {
            System.err.println("Error reading username");
            e.printStackTrace();
        }
    }

    private void Add_Password() {
        try {
            BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
            password = consoleReader.readLine();
            consoleReader.close();

            /*MessageDigest hash = MessageDigest.getInstance("SHA-256");
            return hash.digest(pw.getBytes(StandardCharsets.UTF_8));*/
        }

        catch (IOException e) {
            System.err.println("Console error");
            e.printStackTrace();
        }

        /*
        catch (NoSuchAlgorithmException e) {
            System.err.println("Wrong SHA");
            e.printStackTrace();
        }
        */
    }

    private void Write_File() throws IOException {
        //File credentials = new File("login.txt");
        FileWriter write = new FileWriter("login.txt");
        write.write(username + "\n" + password);
    }
}