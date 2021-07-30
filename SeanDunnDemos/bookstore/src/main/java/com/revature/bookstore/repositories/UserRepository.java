package com.revature.bookstore.repositories;

import com.revature.bookstore.App;
import com.revature.bookstore.models.AppUser;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class UserRepository implements CrudRepository<AppUser> {

    private File dataSource;
    private AppUser[] users;

    public UserRepository() {
        dataSource = new File("src/main/resources/data.txt");
        users = new AppUser[0];

        int numUsers = 0;
        // check output file
        try {
            Scanner sc = new Scanner(dataSource);
            String line = "";
            while (sc.hasNextLine()) {
                line = sc.nextLine();
                if (!line.equals("")) {
                    numUsers++;
                }
            }
            sc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // if output file is not empty, populate users array
        if (numUsers != 0) {
            AppUser[] newUsers = new AppUser[numUsers];
            int i = 0;  // iterator
            try {
                Scanner scan2 = new Scanner(dataSource);
                String line = "";
                while (scan2.hasNextLine()) {
                    line = scan2.nextLine();
                    if (!line.equals("")) {
                        String[] parts = line.split("\\:");
                        newUsers[i] = new AppUser(parts[1], parts[2], parts[3], parts[4], parts[5]);
                        newUsers[i].setId(Integer.parseInt(parts[0]));
                        i++;
                    }
                }
                scan2.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            populateUsers(newUsers);
        }

//        for (AppUser user : users) {
//            System.out.println(user);
//        }

    }

    @Override
    public AppUser findById(int id) {
        return null;
    }

    @Override
    public AppUser save(AppUser newUser) {

        try {
            FileWriter writer = new FileWriter(dataSource, true);

            // Read output file for last id entered
            Scanner sc = new Scanner(dataSource);
            String line = "";
            int nextID = 1;
            while (sc.hasNextLine()) {
                line = sc.nextLine();
            }
            sc.close();
            if (!line.equals(""))
                nextID = Integer.parseInt(line.substring(0, 1)) + 1;

            newUser.setId(nextID);   // Id is iterated every time a new

            writer.write(newUser.toFile());
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        populateUsers(newUser);


        return newUser;
    }

    public AppUser[] getUsers() {
        return users;
    }

    public void populateUsers(AppUser... newUsers) {
        // Populate new array of users
        AppUser[] finalUserArray = new AppUser[users.length + newUsers.length];
        for (int i = 0; i < finalUserArray.length; i++) {
            if (i >= users.length)
                finalUserArray[i] = newUsers[finalUserArray.length - i - 1];
            else finalUserArray[i] = users[i];
        }
        users = finalUserArray;
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
