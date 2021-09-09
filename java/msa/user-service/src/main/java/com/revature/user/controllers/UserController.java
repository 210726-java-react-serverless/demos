package com.revature.user.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping(path = "/test", produces = "text/plain")
    public String test() {
        return "UserServiceApp works!";
    }

    @GetMapping(path = "/feign", produces = "text/plain")
    public String testFeignClient() {
        return "Synchronous inter-service communication with FeignClient successful!";
    }

}
