package com.revature.book.services;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.revature.book.intercom.UserServiceClient;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private final UserServiceClient userClient;

    public BookService(UserServiceClient userClient) {
        this.userClient = userClient;
    }

    @HystrixCommand(fallbackMethod = "serviceUnavailable")
    public String testFeignClient(String test) {
        return userClient.testFeignClient();
    }

    public String serviceUnavailable(String test) {
        return "The requested service is unavailable at this time, please try again later. Original arg: " + test;
    }

}
