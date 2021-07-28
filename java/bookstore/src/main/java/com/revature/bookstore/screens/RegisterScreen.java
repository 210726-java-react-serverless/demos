package com.revature.bookstore.screens;

import java.io.*;

public class RegisterScreen extends Screen {

    public RegisterScreen() {
        super("RegisterScreen", "/register");
    }

    @Override
    public void render() throws IOException {

        String username;
        String password;

        // collecting user data
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Please enter a Username: ");
        username = in.readLine();
        System.out.println("Your username is: " + username);
        System.out.print("Please enter a Password: ");
        password = in.readLine();
        System.out.println("Your password is: " + password);

        try {
            RegisterScreen rs = new RegisterScreen();
            rs.userWriter(username, password);
        } catch (IOException ioe) {
            System.out.println("there was an IO exception in regards to the userWriter Method");
        }
    }

    private void userWriter(String username, String password) throws IOException {
        FileWriter fw = new FileWriter("src/main/java/com/revature/bookstore/users/credentials.txt", true);
        String entry = "\n" + username + " " + password;
        fw.append(entry);
        fw.flush();
        fw.close();
    }

}
