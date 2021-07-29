package com.revature.bookstore.screens;

import java.io.BufferedReader;
import java.io.IOException;

public class DashboardScreen extends Screen {

    public DashboardScreen(BufferedReader consoleReader) {
        super("DashboardScreen", "/dashboard", consoleReader);
    }

    @Override
    public void render() {
        try {
            consoleReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("DashboardScreen works!");
    }

}
