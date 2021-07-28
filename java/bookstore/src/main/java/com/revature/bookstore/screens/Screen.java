package com.revature.bookstore.screens;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public abstract class Screen {

    protected static BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

    protected String name;
    protected String route;

    public Screen(String name, String route) {
        this.name = name;
        this.route = route;
    }

    public String getName() {
        return name;
    }

    public String getRoute() {
        return route;
    }

    public abstract void render();

}
