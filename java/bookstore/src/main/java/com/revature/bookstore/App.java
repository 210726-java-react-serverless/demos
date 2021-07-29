package com.revature.bookstore;

import com.revature.bookstore.model.UserVolatileDB;
import com.revature.bookstore.model.User;
import com.revature.bookstore.screens.RegisterScreen;
import com.revature.bookstore.screens.Screen;
import com.revature.bookstore.screens.WelcomeScreen;

public class App {

    public static void main(String[] args) {
        //WelcomeScreen welcomeScreen = new WelcomeScreen();
        //welcomeScreen.render();
        //welcomeScreen.closeBuffer();

        RegisterScreen registerScreen = new RegisterScreen();
        registerScreen.render();
        registerScreen.closeBuffer();

        // add records to database (doesn't check for or remove duplicates)
        //UserVolatileDB uvdb = new UserVolatileDB("database.csv");
        //uvdb.addUser(new User("dollodart", "password", "david", "ollodart"));
        //uvdb.addUser(new User("wsingleton", "password", "wezley", "singleton"));
        //uvdb.writePersistent("database.csv");


        /*
        UserVolatileDB uvdb = new UserVolatileDB("database.csv");
        uvdb.printAllUsers();
        User user = uvdb.findUser("dollodart");
        System.out.println(user);
         */
    }

}
