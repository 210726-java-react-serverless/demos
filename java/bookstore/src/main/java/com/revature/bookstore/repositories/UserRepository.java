package com.revature.bookstore.repositories;

import com.revature.bookstore.models.AppUser;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class UserRepository implements CrudRepository<AppUser> {

    private File dataSource;
    public UserRepository(){
        dataSource = new File("src/main/resources/data.txt");
    }

    @Override
    public AppUser findById(int id) {
        return null;
    }

    @Override
    public AppUser save(AppUser newUser) {
        try {
            FileWriter writer = new FileWriter(dataSource,true);
            newUser.setId(numberOfUsers());
            writer.write(newUser.toFile());
            writer.write("\n");
            writer.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }

        return newUser;
    }

    public int numberOfUsers(){
        Scanner scanner;
        try{
            scanner = new Scanner(dataSource);
            int count=0;
            while(scanner.hasNextLine()) {
                scanner.nextLine();
                count++;
            }
            return count;
        }
        catch( IOException e){
            e.printStackTrace();
        }
        return 0;
    }

    public AppUser findByUserCredentials(String username, String password){

        Boolean userFound = false;
        Scanner scanner;
        String user, pass, email, firstName, lastName;
        int id;
        try{
            scanner = new Scanner(dataSource);
            scanner.useDelimiter(":");

            while(scanner.hasNextLine()) {
                id = Integer.parseInt(scanner.next());
                user = scanner.next();
                pass = scanner.next();

                if(username.equals(user))
                    if(password.equals(pass)) {
                        email = scanner.next();
                        firstName = scanner.next();
                        lastName = scanner.next();
                        AppUser foundUser = new AppUser(user,pass,email,firstName,lastName);
                        foundUser.setId(id);
                        return  foundUser;
                    }
                scanner.nextLine();
            }
            scanner.close();
        }
        catch( IOException e){
            e.printStackTrace();
        }
        return null;
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
