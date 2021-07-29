package com.revature.bookstore.repositories;

import com.revature.bookstore.models.AppUser;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class UserRepository implements CrudRepository<AppUser> {

    private File dataSource;

    @Override
    public AppUser findById(int id) {
        return null;
    }

    @Override
    public AppUser save(AppUser newUser) {
        dataSource = new File("java/bookstore/src/main/resources/data.txt");

        System.out.println(dataSource.getPath());

        try(FileWriter writer = new FileWriter(dataSource);) {

            newUser.setId(); // TODO this will need to be fixed, as all users will have the same id.
            writer.write(newUser.toFile());
            writer.flush();
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
