package com.revature.bookstore.util;

import com.revature.bookstore.repositories.UserRepository;
import com.revature.bookstore.screens.*;
import com.revature.bookstore.services.UserService;


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AppState {

    private boolean app_running;
    private final ScreenRouter router;

    public AppState() {
        app_running = true;
        router = new ScreenRouter();
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

        UserRepository userRepo = new UserRepository();
        UserService userService = new UserService(userRepo);

        router.addScreen(new WelcomeScreen(consoleReader, router))
              .addScreen(new LoginScreen(consoleReader, router, userService))
              .addScreen(new RegisterScreen(consoleReader, router, userService))
              .addScreen(new DashboardScreen(consoleReader, router));
    }

    public void startup() {
        router.navigate("/welcome");

        while (app_running) {
            try {
                router.getCurrentScreen().render();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
