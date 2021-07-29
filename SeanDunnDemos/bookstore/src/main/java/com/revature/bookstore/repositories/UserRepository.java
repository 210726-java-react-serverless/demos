package com.revature.bookstore.repositories;

import com.revature.bookstore.models.AppUser;

import java.io.File;
import java.io.FileWriter;

public class UserRepository implements CrudRepository<AppUser> {

    private File dataSource;
    private AppUser[] users = new AppUser[0];

    @Override
    public AppUser findById(int id) {
        return null;
    }

    @Override
    public AppUser save(AppUser newUser, int iterator) {
        dataSource = new File("src/main/resources/data.txt");
        try {
            FileWriter writer = new FileWriter(dataSource, true);
            newUser.setId(iterator);   // Id is iterated every time a new
            writer.write(newUser.toFile());
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Populate array of new users
        AppUser[] newUserArray = new AppUser[users.length + 1];
        for (int i = 0; i < newUserArray.length; i++) {
            if (i == users.length) {
                newUserArray[i] = newUser;
                break;
            }
            newUserArray[i] = users[i];
        }
        users = newUserArray;

        return newUser;
    }

    public AppUser[] getUsers() {
        return users;
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
