package com.revature.bookstore.repositories;

import com.revature.bookstore.models.AppUser;

import java.io.*;

public class UserRepository implements CrudRepository<AppUser> {

    private File dataSource;

    @Override
    public AppUser findById(int id) {
        return null;
    }


    public boolean findByName(String username, String password) {
        dataSource = new File("src/main/resources/data.txt");
        try (
                BufferedReader reader = new BufferedReader(new FileReader(dataSource));
        ) {
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
        } return false;
    }

    @Override
    public AppUser save(AppUser newUser) {
        dataSource = new File("src/main/resources/data.txt");

        try {
            FileWriter writer = new FileWriter(dataSource);
            newUser.setId(1); // TODO this will need to be fixed, as all users will have the same id.
            writer.write(newUser.toFile());
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