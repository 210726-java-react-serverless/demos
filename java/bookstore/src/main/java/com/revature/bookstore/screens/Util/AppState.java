package com.revature.bookstore.screens.Util;

import com.revature.bookstore.screens.WelcomeScreen;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AppState {
    private boolean appRunning;
    private final ScreenRouter router;

    public AppState() {
        appRunning = true;
        router = new ScreenRouter();
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));


        router.addScreen(new WelcomeScreen(consoleReader, router))
                .addScreen(new LoginScreen(consoleReader, router))
                .addScreen(new RegisterScreen(consoleReader, router))
                .addScreen(new DashboardScreen(consoleReader, router));

    }

    public void startup() {
        router.navigate("/welcome");

        while (appRunning) {
            try {
                router.getCurrentScreen().render();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

}

}

