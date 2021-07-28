package com.revature.java_basics.models;

import java.util.Arrays;
import java.util.Objects;

/*
    POJO = Plain Ol' Java Object

        - A simple container for data
        - Does not usually contain complex logic
        - Has private fields that are exposed via getters/setters
        - Might have multiple constructors that can be used to instantiate instances
        - Often times will override inherited Object class methods

 */
public class Person {

    // Static fields
    private static String staticString = "This is static";

    // Instance fields
    private String firstName;
    private String lastName;
    private String email;
    private int age;
    private String[] skills;

    // Constructors
    public Person() {
        super(); // implicitly included, if the class has no declared parent this invoked the Object class's constructor
        this.skills = new String[] { "Java", "JavaScript", "HTML", "CSS" };
    }

    public Person(String fn, String ln, String email) {
        this();
        firstName = fn;
        lastName = ln;
        this.email = email;
    }

    public Person(String fn, String ln, String email, int age) {
        this(fn, ln, email);
        this.age = age;
    }

    // Static and instance methods
    public static String getStaticString() {
        return staticString;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String newFirstName) {
        if (newFirstName == null) {
            return;
        }

        this.firstName = newFirstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String[] getSkills() {
        return skills;
    }

    public void setSkills(String[] skills) {
        this.skills = skills;
    }

    /*
        We often times override the equals method to check for value equivalence, because
        the default implementation provided by Object.equals uses the == operator.
     */
    @Override // technically, not required, but good practice to include so its obvious that we are overriding an inherited method
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age
                && Objects.equals(firstName, person.firstName)
                && Objects.equals(lastName, person.lastName)
                && Objects.equals(email, person.email)
                && Arrays.equals(skills, person.skills);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(firstName, lastName, email, age);
        result = 31 * result + Arrays.hashCode(skills);
        return result;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", skills=" + Arrays.toString(skills) +
                '}';
    }
}
