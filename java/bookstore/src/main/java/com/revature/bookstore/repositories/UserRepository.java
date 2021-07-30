package com.revature.bookstore.repositories;

import com.revature.bookstore.models.AppUser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class UserRepository implements CrudRepository<AppUser> {

    private File data_source;

    @Override
    public AppUser FindByID(int id) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/main/resources/data.txt"));
            String s;
            while ((s = br.readLine()) != null) {
                if (s.contains(Integer.toString(id))) {
                    // convert s to AppUser
                    String[] parse = s.split(":");
                    // Should ideally be done through some DB
                    return new AppUser(parse[1], parse[2], parse[3], parse[4], parse[5]);
                }
            }
        } catch (Exception FileNotFoundException) {
            System.err.println("File not found");
        }

        return null;
    }

    @Override
    public AppUser Save(AppUser newUser) {
        data_source = new File("src/main/resources/data.txt");

        try {
            FileWriter writer = new FileWriter(data_source, true);
            writer.append(newUser.To_File());
            writer.flush();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return newUser;
    }

    @Override
    public boolean Update(AppUser updated_resource) {
        return false;
    }

    @Override
    public boolean DeleteById(int id) {
        return false;
    }
}
