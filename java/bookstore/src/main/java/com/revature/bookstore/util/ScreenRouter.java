package com.revature.bookstore.util;

import com.revature.bookstore.screens.Screen;

import java.util.HashSet;
import java.util.Set;

public class ScreenRouter {

    private Screen current_screen;
    private Set<Screen> screens = new HashSet<>();

    public ScreenRouter addScreen(Screen screen) {
        screens.add(screen);
        return this;
    }

    public void navigate(String route) {
        for (Screen screen : screens) {
            if (screen.getRoute().equals(route)) {
                current_screen = screen;
                break;
            }
        }
    }

    public Screen getCurrentScreen() {
        return current_screen;
    }
}
