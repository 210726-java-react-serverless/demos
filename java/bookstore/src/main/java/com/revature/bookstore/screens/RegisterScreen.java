package com.revature.bookstore.screens;

import com.revature.bookstore.models.AppUser;
import com.revature.bookstore.services.UserService;
import com.revature.bookstore.util.ScreenRouter;

import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class RegisterScreen extends Screen {

    private UserService userService;

    public RegisterScreen(BufferedReader consoleReader, ScreenRouter router, UserService userService) {

        super("RegisterScreen", "/register", consoleReader, router);

        this.userService=userService;
    }

    @Override
    public void render() throws Exception {
        String user = tryParse("Enter username\n> ");

        String pass = tryParse("Enter password\n> ");

        String email = tryParse("Enter email\n> ");

        String firstName = tryParse("Enter first name\n> ");

        String lastName = tryParse("Enter last name\n> ");

        AppUser newUser = new AppUser(user,pass, email,firstName,lastName);

        userService.register(newUser);

    }
    public String tryParse(String prompt){
        System.out.print(prompt);
        try {
            String input = consoleReader.readLine(); // if an exception is thrown this will not be executed
            return input;
        }catch(IOException e){
            e.printStackTrace();
        }
        return "Something went wrong";
    }
    public void toFile(String textLine){
        try {
            FileWriter write = new FileWriter("./creds.txt", true);
            PrintWriter print_line = new PrintWriter(write);
            print_line.printf("%s ",textLine);
            print_line.close();
        }catch(Exception ex){
            System.out.println(ex);
        }
    }

}
