package com.revature.bookstore.util;

import com.revature.bookstore.exceptions.InvalidRouteException;
import com.revature.bookstore.screens.Screen;

import java.util.HashSet;
import java.util.Set;

public class ScreenRouter {

    private Screen currScreen;
    private Set<Screen> screens = new HashSet<>();

    public void addScreen(Screen screen) {
        screens.add(screen);
    }

    public void navigate(String route) {
        boolean found = false;
        for(Screen screen: screens) {
            if(screen.getRoute().equals(route)) {
                currScreen = screen;
                found = true;
                break;
            }
        }
        if(!found) {
            throw new InvalidRouteException("Bad route");
        }
    }

    public Screen getCurrScreen() {
        return currScreen;
    }
}
