package com.revature.bookstore.util;

import com.revature.bookstore.repository.UserRepository;
import com.revature.bookstore.screens.DashScreen;
import com.revature.bookstore.screens.HomeScreen;
import com.revature.bookstore.screens.LoginScreen;
import com.revature.bookstore.screens.RegisterScreen;
import com.revature.bookstore.services.UserService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AppState {
    private boolean alive;
    private final ScreenRouter router;

    public AppState() {
        alive = true;
        router = new ScreenRouter();
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        UserRepository userRepo = new UserRepository();
        UserService userService = new UserService(userRepo);

        init(consoleReader, userService);


    }

    private void init(BufferedReader consoleReader, UserService userService) {
        router.addScreen(new HomeScreen(consoleReader, router));
        router.addScreen(new LoginScreen(consoleReader, router, userService));
        router.addScreen(new RegisterScreen(consoleReader, router, userService));
        router.addScreen(new DashScreen(consoleReader, router));
    }

    public void startup() {
        router.navigate("/home");

        while(alive) {
            try {
                router.getCurrScreen().render();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


}
