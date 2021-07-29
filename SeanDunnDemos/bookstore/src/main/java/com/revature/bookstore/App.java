package com.revature.bookstore;

import com.revature.bookstore.screens.RegisterScreen;
import com.revature.bookstore.screens.WelcomeScreen;
import com.revature.bookstore.util.AppState;

import java.io.BufferedReader;

public class App {

//    public static BufferedReader;   // Will work, but breaks encapsulation, not preferred

    public static void main(String[] args) {
//        WelcomeScreen welcomeScreen = null; // null pointer exception; no object to reference

        AppState app = new AppState();
        app.startup();
//        WelcomeScreen welcomeScreen = new WelcomeScreen();


    }
}
