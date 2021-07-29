package com.revature.bookstore.screens;

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

    //render method stub
    public abstract void render() throws Exception;
}