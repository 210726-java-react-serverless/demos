package com.revature.bookstore;

import com.revature.bookstore.screens.RegisterScreen;
import com.revature.bookstore.screens.WelcomeScreen;

public class App {
    public static void main(String[] args) {
//        WelcomeScreen welcomeScreen = null; // null pointer exception; no object to reference
        WelcomeScreen welcomeScreen = new WelcomeScreen();
        welcomeScreen.render();
        switch (Integer.parseInt(welcomeScreen.getUserSelection())) {
           case 1:
               break;
            case 2:
               RegisterScreen registerScreen = new RegisterScreen();
               registerScreen.render();
               break;
       }
    }
}
