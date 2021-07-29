package com.revature.bookstore.screens;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import com.revature.bookstore.model.UserVolatileDB;

public abstract class Screen {

    protected static BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
    protected static UserVolatileDB database = new UserVolatileDB("database.csv");

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

    public void closeBuffer() {
    database.writePersistent("database.csv");
    // note: this will overwrite database if it it wasn't initialized with the file
    try {
	    consoleReader.close();
	} catch (java.io.IOException ioe) {
	    System.out.println("couldn't print to system");}
    }

}
