package com.revature.bookstore.screens;

import java.io.IOException;

public class RegistrationScreen extends Screen{
    public RegistrationScreen(){
        super("Registration","Register");
    }

    @Override
    public void render() throws IOException {
        System.out.println("Welcome to the Registration page");
        Person registrant = new Person();
        registrant.Render();


    }
}
