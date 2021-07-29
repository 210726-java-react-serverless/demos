package com.revature.bookstore;

import com.revature.bookstore.screens.Screen;
import com.revature.bookstore.screens.WelcomeScreen;
import com.revature.bookstore.util.AppState;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class App {

    public static void main(String[] args) {
        AppState app = new AppState();
        app.startUp();
    }

}
