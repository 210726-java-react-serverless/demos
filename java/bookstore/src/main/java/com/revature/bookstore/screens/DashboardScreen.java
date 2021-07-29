package com.revature.bookstore.screens;

import com.revature.bookstore.util.ScreenRouter;

import java.io.BufferedReader;
import java.io.IOException;

public class DashboardScreen extends Screen {

    public DashboardScreen(BufferedReader consoleReader, ScreenRouter router) {
        super("DashboardScreen", "/dashboard", consoleReader, router);
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
