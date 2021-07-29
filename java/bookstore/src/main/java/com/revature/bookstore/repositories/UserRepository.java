package com.revature.bookstore.repositories;

import com.revature.bookstore.models.AppUser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

public class UserRepository implements CrudRepository<AppUser> {

    private File dataSource;

    @Override
    public AppUser findById(int id) {
        return null;
    }

    @Override
    public AppUser save(AppUser newUser) {
        dataSource = new File("src/main/resources/data.txt");


        try (FileWriter writer = new FileWriter(dataSource, true)) {
            newUser.setId(getID(dataSource)); // TODO this will need to be fixed, as all users will have the same id.
            writer.append(newUser.toFile());
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


    public int getID(File n){

        int NewId = 0;

        try {
            Scanner s = new Scanner(n);
            while(s.hasNextLine()) {
                NewId++;
                s.nextLine();
                System.out.println("increased ID");
            }

            s.close();
        } catch (FileNotFoundException e) {
            System.out.println("Data file wasn't found!");
        }

        return NewId;

    }

}
