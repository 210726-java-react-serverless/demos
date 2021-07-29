package com.revature.bookstore;

import com.revature.bookstore.screens.Screen;

import java.util.Dictionary;
import java.util.Hashtable;

public class Router {
    //Want dict containing key: "Name', value: Screen Obj
    Dictionary screens = new Hashtable();

    public void initScreen(Screen s) {
        screens.put(s.getName(), s);
    }

    public void switchScreen(String s) throws Exception{
        Screen target = (Screen)screens.get(s);
        target.render();
    }

}
