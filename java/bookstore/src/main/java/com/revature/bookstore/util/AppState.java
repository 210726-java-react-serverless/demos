package com.revature.bookstore.util;

import com.revature.bookstore.repositories.UserRepository;
import com.revature.bookstore.screens.DashboardScreen;
import com.revature.bookstore.screens.LoginScreen;
import com.revature.bookstore.screens.RegisterScreen;
import com.revature.bookstore.screens.WelcomeScreen;
import com.revature.bookstore.services.UserService;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AppState {

    private boolean appRunning;
    private final ScreenRouter router;

    public AppState() {
        appRunning = true;
        router = new ScreenRouter();
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

        // Create app components
        UserRepository userRepo = new UserRepository("src/main/resources/data.txt");
        UserService userService = new UserService(userRepo);


        router.addScreen(new WelcomeScreen(consoleReader, router))
              .addScreen(new LoginScreen(consoleReader, router, userService))
              .addScreen(new RegisterScreen(consoleReader, router, userService))
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
