package com.revature.bookstore.repositories;

import com.revature.bookstore.models.AppUser;
import com.revature.bookstore.screens.LoginScreen;
import com.revature.bookstore.screens.Screen;


import java.nio.file.Files;
import java.nio.file.Paths;

import java.io.*;


public class UserRepository implements CrudRepository<AppUser> {

    private File dataSource = new File("src/main/resources/data.txt");
    /*
    This method Reads and returns a boolean depending on the screen that calls the method. This assumes each screen
    will have a default reason to search the UserRepo.
     */
    public boolean search(Screen callingScreen) {
        try (
                BufferedReader reader = new BufferedReader(new FileReader(this.getDataSource()));
        ) {
            if(callingScreen instanceof LoginScreen) {
                LoginScreen login = (LoginScreen) callingScreen; //I checked to make sure this downcasting doesn't create a new instance of LoginScreen.
                return loginSearch(login.getLoginUsername(), login.getLoginPassword(), reader);
            }
        } catch (IOException e) {
            System.err.print("Exception thrown from file search.");
        }  return false; //Intellij complains unless i put this return statement here.
    }

    //Implementation of the search method for the login screen.
    public boolean loginSearch(String username, String password, BufferedReader reader) throws IOException{
        String line = reader.readLine();
        while (line != null) {
            String[] splittedLine = line.split(":");
            if ((splittedLine[4].equals(username)))
                if ((splittedLine[5].equals(password)))
                    return true;
            line=reader.readLine();
        } return false;

    }

    @Override
    public AppUser findById(int id) {
        return null;
    }

    @Override
    public AppUser save(AppUser newUser) {

        try {

            FileWriter writer = new FileWriter(this.getDataSource(), true);
            newUser.setId(newUser.getId());
            writer.append(newUser.toFile());
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

    public void setDataSource(File dataSource) {
        this.dataSource = dataSource;
    }

    public File getDataSource() {
        return dataSource;
    }
}
