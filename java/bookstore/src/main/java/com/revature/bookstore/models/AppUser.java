package com.revature.bookstore.models;

import java.util.Objects;

public class AppUser {

    private int id;
    private String username;
    private String password;
    private String email;
    private String firstName;
    private String lastName;

    public AppUser(String username, String password, String email, String firstName, String lastName) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail(){
        return email;
    }

    public String toFile() {

        StringBuilder builder = new StringBuilder();
        builder.append(id).append(":")
               .append(firstName).append(":")
               .append(lastName).append(":")
               .append(email).append(":")
               .append(username).append(":")
               .append(password);

        return builder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AppUser appUser = (AppUser) o;

        return id == appUser.id
                && Objects.equals(firstName, appUser.firstName)
                && Objects.equals(lastName, appUser.lastName)
                && Objects.equals(email, appUser.email)
                && Objects.equals(username, appUser.username)
                && Objects.equals(password, appUser.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email, username, password);
    }

    @Override
    public String toString() {
        return "AppUser{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

}
