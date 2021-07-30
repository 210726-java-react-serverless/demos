package com.revature.bookstore.repositories;

import com.revature.bookstore.models.AppUser;


import java.nio.file.Files;
import java.nio.file.Paths;

import java.io.*;


public class UserRepository implements CrudRepository<AppUser> {

    private File dataSource;
    /*
    I put this method here instead of making it part of the CRUDREP interface because the logic is
    specific to finding the username and password. I maybe could have parameterized it as a String varargs
    to take any one of the AppUser fields, and use it more as a general search method.
     */
    public boolean authenticate(String username, String password) {
        dataSource = new File("src/main/resources/data.txt");
        try (
                BufferedReader reader = new BufferedReader(new FileReader(dataSource));
        ) {
            /*Each line of the data.txt file is split into a string array. Assuming that the order in which AppUser
             fields are saved doesn't change, we know ahead of time where each field will be in the array.
             */
            String line = reader.readLine();
            while (line != null) {
                String[] splittedLine = line.split(":");
                if ((splittedLine[4].equals(username)))
                    if ((splittedLine[5].equals(password)))
                        return true;
                line=reader.readLine();
            } return false;
        } catch (IOException e) {
            System.err.print("Exception thrown from file search.");
        } return false; //the method should never reach this return statement, but Intellij complained.
    }

    @Override
    public AppUser findById(int id) {
        return null;
    }

    @Override
    public AppUser save(AppUser newUser) {

        try {
            dataSource = new File("src/main/resources/data.txt");
            FileWriter writer = new FileWriter(dataSource, true);
            newUser.setId(newUser.getId());
            writer.append(newUser.toFile());
            writer.flush();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return newUser;

    }

    @Override
    public boolean update(AppUser updatedResource) {
        return false;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }

}
