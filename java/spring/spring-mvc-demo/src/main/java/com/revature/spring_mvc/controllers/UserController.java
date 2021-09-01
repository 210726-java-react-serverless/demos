package com.revature.spring_mvc.controllers;

import com.revature.spring_mvc.dtos.ErrorResponse;
import com.revature.spring_mvc.exceptions.InvalidRequestException;
import com.revature.spring_mvc.exceptions.ResourceNotFoundException;
import com.revature.spring_mvc.models.AppUser;
import com.revature.spring_mvc.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // implies @Controller at the class-level, and @ResponseBody on the method-level
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/json", produces = "application/json")
    public List<AppUser> getAllUsers_json() {
        return userService.getAllUsers_json();
    }

    @GetMapping(value = "/id", produces = "application/json")
    public AppUser getUserById(@RequestParam int id) {
        return userService.getById(id);
    }


}
