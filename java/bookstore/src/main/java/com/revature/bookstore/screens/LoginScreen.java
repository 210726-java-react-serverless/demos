package com.revature.bookstore.screens;


import com.revature.bookstore.repositories.UserRepository;
import com.revature.bookstore.util.ScreenRouter;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;

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
        UserRepository repo = new UserRepository(); //see the authenticate() method in the UserRepo class definition
        try{
            BufferedReader stream  = new BufferedReader(new InputStreamReader(System.in));
            /* User inputs username and password, both are passed to the authenticate method. Passed in an
             unending while loop that only breaks if you enter valid credentials, or you type 'exit' for the username.
             */
            while(true) {
                System.out.print("Enter your username, or type 'exit' to exit: ");
                String username = stream.readLine();
                if(username.equals("exit"))
                    break;
                System.out.print("Enter your password: ");
                String password = stream.readLine();
                if (repo.authenticate(username, password)) {
                    System.out.println("Login successful!");
                    break;
                } else{
                    System.out.println("Invalid username or password. Please try again, or type 'exit'");
                }

            }
                router.navigate("/welcome");
            } finally{
                            /*this finally block needed to keep Intellij happy. Can't close this stream or else the
                            while loop in startup() will loop forever. The Welcome Screen won't have an open stream to
                            read from, so an exception is thrown up to the AppState.startup() method, which will print
                            the stack trace and continue the while loop, running into the same error over and over again.
                             */
            }

    }


}
