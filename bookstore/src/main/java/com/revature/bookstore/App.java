package com.revature.bookstore;

import com.revature.bookstore.screens.WelcomeScreen;

public class App {
    public static void main(String[] args) {
//        WelcomeScreen welcomeScreen = null; // null pointer exception; no object to reference
        WelcomeScreen welcomeScreen = new WelcomeScreen();
        welcomeScreen.render();
        System.out.println("test");
    }
}
