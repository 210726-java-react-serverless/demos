package com.revature.bookstore.users;

import java.io.*;

public class UserChecker {

    private String userName;
    private String passWord;

    public void write() {


        File file = new File("credentials");

        try {
            FileOutputStream fWriter = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            System.out.println("Error, file not found.");
        }

        try {
            FileWriter fw = new FileWriter("src/main/java/com/revature/bookstore/users/credentials.txt");
        } catch (IOException e) {
            System.out.println("An IO Exception has occurred in regards to FileWriter!");
        }
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
