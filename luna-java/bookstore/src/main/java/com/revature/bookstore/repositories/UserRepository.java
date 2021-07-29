package com.revature.bookstore.repositories;

import com.revature.bookstore.models.AppUser;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class UserRepository implements CrudRepository<AppUser> {

    private File dataSource;
    public UserRepository() {
        dataSource = new File("src/main/resources/data.txt");
    }

    @Override
    public AppUser findById(int id) {
        return null;
    }

    public AppUser findByUserCredentials(String username, String password) {

        try (Scanner reader = new Scanner(dataSource).useDelimiter(":")) {

            boolean reading = true;
            while (reading) {
                String tempId = reader.next();
                String tempFirstName = reader.next();
                String tempLastName = reader.next();
                String tempEmail = reader.next();
                String tempUsername = reader.next();
                if (tempUsername.equals(username)) {
                    String tempPassword = reader.next();
                    if (tempPassword.equals(password)) {
                        AppUser loggedIn = new AppUser(tempFirstName, tempLastName, tempEmail, tempUsername, tempPassword);
                        loggedIn.setId(Integer.parseInt(tempId));
                        return loggedIn;
                    }

                }
                reader.nextLine();
                if (reader.next().equals("") || reader.next() == null) {
                    reading = false;
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public AppUser save(AppUser newUser) {

        try {
            FileWriter writer = new FileWriter(dataSource, true);
            Scanner scanner = new Scanner(dataSource);
            int count=0;
            while(scanner.hasNextLine()) {
                scanner.nextLine();
                count++;
            }
            newUser.setId(count);
            writer.write(newUser.toFile());
            writer.write("\n");
            writer.flush();
            writer.close();
            scanner.close();
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
