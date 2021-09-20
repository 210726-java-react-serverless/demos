package com.revature.poc_lambda;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AppUser {

    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String password;
    private Address address;
    private LocalDateTime registrationDateTime;

}
