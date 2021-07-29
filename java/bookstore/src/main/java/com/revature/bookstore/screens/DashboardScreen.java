package com.revature.bookstore.screens;

import java.io.BufferedReader;

public class DashboardScreen extends Screen {

    public DashboardScreen(BufferedReader consoleReader, ScreenRouter router) {
        super("DashboardScreen", "/dashboard", consoleReader, router);
    }

    @Override
    public void render() throws Exception {
        System.out.println("DashboardScreen works!");
        System.out.println("Screen under construction, sending you back to the Welcome Screen.");
        router.navigate("/welcome");
    }

}
