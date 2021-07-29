package com.revature.bookstore;

import com.revature.bookstore.screens.Screen;
import com.revature.bookstore.screens.WelcomeScreen;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class App {

    public static void main(String[] args) {
        new Screen("FakeScreen", "/fake", new BufferedReader(new InputStreamReader(System.in)));
        WelcomeScreen welcomeScreen = new WelcomeScreen();
        welcomeScreen.render();
    }

}
