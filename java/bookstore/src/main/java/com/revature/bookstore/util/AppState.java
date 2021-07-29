package com.revature.bookstore.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AppState {

    private final ScreenRouter router;

    public AppState() {
        router = new ScreenRouter();
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));


    }

}
