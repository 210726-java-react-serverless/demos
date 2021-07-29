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

    private final ScreenRouter router;
    private boolean appRunning;

    public AppState() {
        appRunning = true;
        router = new ScreenRouter();
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

        UserRepository userRepo = new UserRepository();
        UserService userService = new UserService(userRepo);

        router.addScreen(new WelcomeScreen(consoleReader, router));
        router.addScreen(new RegisterScreen(consoleReader, router, userService));
        router.addScreen(new DashboardScreen(consoleReader, router));
        router.addScreen(new LoginScreen(consoleReader, router));

    }

    public void startUp(){
        router.navigate("/welcome");
        while(appRunning){
            try {
                router.getCurrentScreen().render();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }

}
