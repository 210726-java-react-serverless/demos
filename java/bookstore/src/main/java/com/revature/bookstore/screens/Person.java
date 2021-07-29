package com.revature.bookstore.screens;

import java.util.ArrayList;

public class Person {
    String lastname;
    String firstname;
    String username;
    String password;

// portions of below code inspired by Tutorialspoint and W3 articles that I read

    Person(String LN,String FN,String UN, String PW){
        this.lastname = LN;
        this.firstname = FN;
        this.username = UN;
        this.password = PW;
    }

    public void PersonDetails(){
        ArrayList<String> registrant = new ArrayList<String>();
        registrant.add(lastname);
        registrant.add(firstname);
        registrant.add(username);
        registrant.add(password);

        System.out.println(registrant);

    }

    public void Render(){
        
    }
}
