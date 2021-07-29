package com.revature.bookstore.util;

import com.revature.bookstore.screens.Screen;

import java.util.HashSet;
import java.util.Set;

public class ScreenRouter {

    private Set<Screen> screens = new HashSet<>();
    private Screen currentScreen;

    public void addScreen(Screen screen){
        screens.add(screen);
    }
    public void navigate(String route){

        for (Screen screen: screens){
            if(screen.getRoute().equals(route)) {
                currentScreen = screen;
                break;
            }
        }
    }
    public Screen getCurrentScreen(){ return currentScreen; }
}
