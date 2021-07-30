package com.revature.bookstore.repositories;

import com.revature.bookstore.models.AppUser;

import java.io.*;

public class UserRepository implements CrudRepository<AppUser> {
    private File dataSource;

    @Override
    public AppUser findById(int id) {
        return null;
    }

    @Override
    public int getNextId() {
        if (dataSource == null) {
            dataSource = new File("src/main/resources/data.txt");
        }

        try {
            BufferedReader fileReader = new BufferedReader(new FileReader(dataSource));

            String str;
            String temp = null;

            while ((str = fileReader.readLine()) != null) {
                temp = str;
            }

            if (temp != null) {
                String[] tokens = temp.split(":");
                return (Integer.parseInt(tokens[0]));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return -1;
    }

    @Override
    public AppUser save(AppUser newUser) {
        if (dataSource == null) {
            dataSource = new File("src/main/resources/data.txt");
        }

        try {
            FileWriter writer = new FileWriter(dataSource, true);

            int id = getNextId();

            if (id != -1) {
                newUser.setId(id + 1);
            } else { // new user not saved
                return newUser;
            }

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
