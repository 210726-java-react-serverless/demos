package com.revature.bookstore.screens;

import java.io.IOException;

public abstract class Screen {

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

    public abstract void render() throws IOException;

}
