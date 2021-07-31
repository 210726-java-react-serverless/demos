package com.revature.java_basics;

import com.revature.java_basics.models.Person;

public class PojoDemo {

    public static void main(String[] args) {
        Person person_1 = new Person(); // legal because Person has a declared no-args constructor
        System.out.println(person_1);

        Person person_2 = new Person("Wezley", "Singleton", "wezley.singleton@revature.com");
        System.out.println(person_2);

        Person person_3 = new Person("Alice", "Anderson", "alice.anderson@revature.com", 25);
        System.out.println(person_3);

        Person person_4 = new Person("Alice", "Anderson", "alice.anderson@revature.com", 25);
        System.out.println(person_3 == person_4); // false
        System.out.println(person_3.equals(person_4)); // returns false if the equals method is not overridden'

        System.out.println(person_3.hashCode());
        System.out.println(person_4.hashCode());
        System.out.println(person_2.hashCode());
    }
}
