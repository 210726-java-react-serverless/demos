package com.revature.bookstore;

import com.revature.bookstore.screens.RegisterScreen;
import com.revature.bookstore.screens.WelcomeScreen;

public class App {

    public static void main(String[] args) {
        WelcomeScreen welcomeScreen = new WelcomeScreen();
        welcomeScreen.render();
        welcomeScreen.closeBuffer();

        //RegisterScreen registerScreen = new RegisterScreen();
        //registerScreen.render();
        //registerScreen.closeBuffer();
    }

}
