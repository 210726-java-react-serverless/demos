package com.revature.bookstore.repositories;

import com.revature.bookstore.models.AppUser;

import java.io.File;
import java.io.FileWriter;

public class UserRepository implements CrudRepository<AppUser> {

    private File dataSource;

    @Override
    public AppUser findById(int id) {
        return null;
    }

    @Override
    public AppUser save(AppUser newUser) {
        dataSource = new File("src/main/resources/data.txt");
        try {
            FileWriter writer = new FileWriter(dataSource);
            newUser.setId(1);
            writer.write(newUser.toFile());
            writer.close();
            
        }
        catch(Exception e){
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
