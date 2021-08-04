package com.revature.bookstore.repositories;

import com.revature.bookstore.models.AppUser;

import java.io.*;

public class UserRepository implements CrudRepository<AppUser> {

    private final File userDataSource;

    public UserRepository(String dataSourcePath) {
        userDataSource = new File(dataSourcePath);
    }

    public AppUser findUserByCredentials(String username, String password) {

        try (BufferedReader reader = new BufferedReader(new FileReader(userDataSource))) {

            String record;
            while ((record = reader.readLine()) != null) {
                String[] recordValues = record.split(":");
                if (recordValues[4].equals(username) && recordValues[5].equals(password)) {
                    return new AppUser(Integer.parseInt(recordValues[0]), recordValues[1], recordValues[2], recordValues[3], recordValues[4], recordValues[5]);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;

    }

    public AppUser findUserByUsername(String username) {
        return null;
    }

    @Override
    public AppUser findById(int id) {
        return null;
    }

    @Override
    public AppUser save(AppUser newUser) {

        System.out.println("UserRepository.save invoked!");

        try (FileWriter writer = new FileWriter(userDataSource, true)) {
            newUser.setId(getNextId());
            writer.write(newUser.toFile() + "\n");
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

    private int getNextId() {

        try (BufferedReader reader = new BufferedReader(new FileReader(userDataSource))) {

            String currentRecord, lastRecord = null;
            while ((currentRecord = reader.readLine()) != null) {
                lastRecord = currentRecord;
            }

            if (lastRecord == null) {
                return 1;
            }

            return Integer.parseInt(lastRecord.split(":")[0]) + 1;


        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error reading file.");
        }

    }

}
