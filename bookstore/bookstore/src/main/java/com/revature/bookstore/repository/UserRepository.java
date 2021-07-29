package com.revature.bookstore.repository;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Random;
import com.revature.bookstore.models.AppUser;

import java.io.File;
import java.io.FileWriter;

public class UserRepository implements CrudRepository<AppUser> {
    private File dataSource;

    @Override
    public AppUser findById(int id) {
        return null;
    }

    // read through file, return the user with a matching username and password
    public AppUser findUserByCredentials(String username, String password) {
        dataSource = new File("src/main/resources/data.txt");
        AppUser user = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(dataSource))){

            String str = reader.readLine();
            while(str != null) {
                //check it

                //System.out.println(str.split(":"));
                String[] parts = str.split(":");
                if(parts[4].equals(username) && parts[5].equals(password)) {
                    user = new AppUser(parts[1], parts[2], parts[3], parts[4], parts[5]);
                    user.setId(Integer.parseInt(parts[0]));
                    break;
                }
                str = reader.readLine();
            }

            //String str = reader.readLine();
            //System.out.println(str);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public AppUser save(AppUser newResource) {
        dataSource = new File("src/main/resources/data.txt");

        try (FileWriter writer = new FileWriter(dataSource, true)){
            newResource.setId(generateId());
            writer.write(newResource.toFile());
            writer.flush();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return newResource;
    }

    @Override
    public boolean update(AppUser updatedResource) {
        return false;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }

    private int generateId() {
        Random rand = new Random();

        int rando = rand.nextInt();
        //Todo: Check if Id is already used

        return rando;
    }
}
