package com.revature.bookstore.util;

import com.revature.bookstore.screens.Screen;

import java.util.HashSet;
import java.util.Set;

public class ScreenRouter {

<<<<<<< HEAD
    private Set<Screen> screens = new HashSet<>();
    private Screen currentScreen;

    public void addScreen(Screen screen){
        screens.add(screen);
    }
    public void navigate(String route){

        for (Screen screen: screens){
            if(screen.getRoute().equals(route)) {
=======
    private Screen currentScreen;
    private Set<Screen> screens = new HashSet<>();

    public ScreenRouter addScreen(Screen screen) {
        screens.add(screen);
        return this;
    }

    public void navigate(String route) {
        for (Screen screen : screens) {
            if (screen.getRoute().equals(route)) {
>>>>>>> 846980801a1c42168f47cf961a68229b941ed89f
                currentScreen = screen;
                break;
            }
        }
    }
<<<<<<< HEAD
    public Screen getCurrentScreen(){ return currentScreen; }
=======

    public Screen getCurrentScreen() {
        return currentScreen;
    }

>>>>>>> 846980801a1c42168f47cf961a68229b941ed89f
}
