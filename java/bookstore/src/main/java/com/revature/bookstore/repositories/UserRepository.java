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
    public AppUser save(AppUser newUser) {
       // dataSource = new File("src/main/resources/data.txt");
        dataSource = new File("demos/java/bookstore/src/main/resources/data.txt");

        try {

            BufferedReader fileReader = new BufferedReader(new FileReader(dataSource));

            int i = Integer.parseInt(fileReader.readLine().split(":")[0]);

            while(fileReader.readLine() != null){
                i++;
            }

            FileWriter writer = new FileWriter(dataSource, true);
            newUser.setId(i+1); // TODO this will need to be fixed, as all users will have the same id.
            writer.write(newUser.toFile());
            writer.write("\n");

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
