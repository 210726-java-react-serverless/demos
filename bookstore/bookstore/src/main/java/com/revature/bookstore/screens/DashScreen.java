package com.revature.bookstore.screens;

import com.revature.bookstore.util.ScreenRouter;

import java.io.BufferedReader;

public class DashScreen extends Screen {

    public DashScreen(BufferedReader consoleReader, ScreenRouter router) {
        super("dash", "/dash", consoleReader, router);
    }

    @Override
    public void render() throws Exception{
        System.out.println("Dash Works");
        router.navigate("/home");
    }
}
