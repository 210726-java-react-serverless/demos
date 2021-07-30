package com.revature.bookstore.models;

import java.util.Objects;

public class AppUser {

    private int id;
    private String first_name;
    private String last_name;
    private String email;
    private String username;
    private String password;

    public AppUser(String f, String l, String e, String u, String p) {
        first_name = f;
        last_name = l;
        email = e;
        username = u;
        password = p;
    }

    public int Get_ID() {return id;}

    public void Set_ID(int id) {this.id = +id;}

    public String Get_First_Name() {return first_name;}

    public void Set_First_Name(String f) {first_name = f;}

    public String Get_last_Name() {return first_name;}

    public void Set_Last_Name(String l) {last_name = l;}

    public String Get_Email() {return first_name;}

    public void Set_Email(String e) {email = e;}

    public String Get_Username() {return username;}

    public void Set_Username(String u) {username = u;}

    public String Get_Password() {return password;}

    public void Set_Password(String p) {password = p;}

    public String To_File() {
        StringBuilder builder = new StringBuilder();
        builder.append(id).append(":")
               .append(first_name).append(":")
               .append(last_name).append(":")
               .append(email).append(":")
               .append(username).append(":")
               .append(password).append("\n");

        return builder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {return true;}
        if (o == null || getClass() != o.getClass()) {return false;}
        AppUser user = (AppUser) o;

        return Objects.equals(first_name, user.first_name)
                && Objects.equals(last_name, user.last_name)
                && Objects.equals(email, user.email)
                && Objects.equals(username, user.username)
                && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first_name, last_name, email, username, password);
    }

    @Override
    public String toString() {
        return "AppUser{" +
                "id=" + id + '\'' +
                "firstName='" + first_name + '\'' +
                ", lastName='" + last_name + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
