package com.revature.bookstore.screens;
import com.revature.bookstore.util.ScreenRouter;

import java.io.BufferedReader;

public class LoginScreen extends Screen{


    public LoginScreen(String name, String route) {
        super(name, route);
    }

    private String loginUsername;
    private String loginPassword;

    public String getLoginUsername() {
        return loginUsername;
    }

    public void setLoginUsername(String loginUsername) {
        this.loginUsername = loginUsername;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    public LoginScreen(BufferedReader consoleReader, ScreenRouter router) {
        super("LoginScreen", "/login", consoleReader, router);
    }

    @Override
    public void render() throws Exception {
        System.out.println("LoginScreen works!");
        System.out.println("Screen under construction, sending you back to the Welcome Screen.");
        router.navigate("/welcome");

    }
}