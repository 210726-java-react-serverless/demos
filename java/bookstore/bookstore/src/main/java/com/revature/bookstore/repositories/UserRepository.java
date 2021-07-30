package com.revature.bookstore.repositories;

import com.revature.bookstore.models.AppUser;

import java.io.*;
import java.util.UUID;

public class UserRepository implements CrudRepository<AppUser> {

    private File dataSource;

    @Override
    public AppUser findById(int id) {
        return null;
    }

    @Override
    public AppUser findByUsername(String userName,String password) {
        BufferedReader br = null;
        AppUser newUser = new AppUser();
        System.out.println(userName + password + "inside userrepo");

        try{
            String strLine;
            //FileReader instance wrapped in a BufferedReader
            br = new BufferedReader(new FileReader("src/main/resources/data.txt"));
            System.out.println(userName + password + "inside try");
            while((strLine = br.readLine()) != null){
                String[] data = strLine.split(":");
                System.out.println("ID :"+ data[0] +"\n"+"Firstname :" + data[1]+"\n" + "LastName :" + data[2] +"\n"+
                        "Email  :" + data[3]+"\n" + "username :"+data[4]+"\n"+"password :"+data[5]);
                newUser.setId(Integer.parseInt(data[0]));
                newUser.setFirstName(data[1]);
                newUser.setLastName(data[2]);
                newUser.setEmail(data[3]);
                newUser.setUsername(data[4]);
                newUser.setPassword(data[5]);

            }
        }catch(IOException exp){
            System.out.println("Error while reading file " + exp.getMessage());
        }finally {
            try {
                // Close the stream
                if(br != null){
                    br.close();
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        if(newUser.getUsername().equals(userName) && newUser.getPassword().equals(password)) {
            return newUser;
        }else
        return null;
    }


    @Override
    public AppUser save(AppUser newUser) {
        dataSource = new File("src/main/resources/data.txt");

        try {
            FileWriter writer = new FileWriter(dataSource);
            String uniqueID = UUID.randomUUID().toString();
            int id = Integer.parseInt(uniqueID);
            newUser.setId(id); // TODO this will need to be fixed, as all users will have the same id.
            writer.write(newUser.toFile());
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
