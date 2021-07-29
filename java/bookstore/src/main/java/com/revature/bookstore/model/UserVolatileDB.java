package com.revature.bookstore.model;

import java.util.Stack;
import java.io.File;  // Import the File class
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;  // Import the IOException class to handle errors
import java.io.FileNotFoundException;
import java.io.BufferedReader;

public class UserVolatileDB {

    private Stack<User> user_stack = new Stack<User>();

    public UserVolatileDB() {}
    public UserVolatileDB(String filename) {
        loadPersistent(filename);
    }

    private void loadPersistent(String filename) {
        BufferedReader br = null;
        File file = new File(filename);
        try {
            br = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(","); // COMMA_DELIMITER from what library?
                user_stack.push(new User(values[0],values[1],values[2],values[3]));
            }
            System.out.printf("Successfully read database file %s.\n", filename);
        } catch (FileNotFoundException fnfe) {fnfe.printStackTrace();} // no file
         catch (IOException ioe) {ioe.printStackTrace();}
        finally {try {br.close();} catch (IOException e) {
            System.out.printf("Couldn't close data base file %s.\n", filename);
            } catch (NullPointerException npe) {
            System.out.printf("Couldn't open buffered reader for %s.\n", filename);
            npe.printStackTrace();}
        }
    }

    public void addUser(User user) {
        // uses O(n) search for duplicates for what should be O(1)
        // use hash table for superior performance
        User foundUser = findUser(user.getUsername());
        if (foundUser != null) {
            System.out.print(foundUser.getUsername()
                    + " is already taken: "
                    + foundUser.getFirstname()
                    + " "
                    + foundUser.getLastname());
        }
        user_stack.push(user);
    }

    // stack search is O(n), other data structures are O(lg(n))
    public User findUser(String username) {
        Stack temp = new Stack();
        while (user_stack.size() > 0) {
            User user = user_stack.pop();
            temp.push(user);
            if (user.getUsername().equals(username)) {
                while (user_stack.size() > 0) {
                    temp.push(user_stack.pop());
                }
                user_stack = temp;
                return user;
            }
        }
        return null;
    }

    public void printAllUsers() {
        Stack temp = new Stack();
        System.out.println("Print all users\n");
        while (user_stack.size() > 0) {
            User user = user_stack.pop();
            System.out.println(user);
            temp.push(user);
        }
        user_stack = temp;
        //return;
    }
    public void writePersistent(String filename) {
        FileWriter myWriter = null; // can also persist with try (FileWriter myWriter = new FileWriter(filename) {...}
        try {
            myWriter = new FileWriter(filename);
            while (user_stack.size() > 0) {
                User user = user_stack.pop();
                String user_row = user.toString();
                myWriter.write(user_row);
                myWriter.write("\n");
            }
            System.out.printf("Successfully wrote to the file %s.\n", filename);
            myWriter.close();
        }
        catch (IOException e){
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        finally {try {myWriter.close();}
            catch (IOException e) {
                System.out.printf("couldn't close FileWriter for %s.\n", filename);}
            catch (NullPointerException npe)
                {System.out.printf("couldn't even create FileWriter class for %s.\n", filename);}
        }
    }
}
