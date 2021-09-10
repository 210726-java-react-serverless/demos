package com.revature.book.services;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.revature.book.dto.QueueMessage;
import com.revature.book.intercom.QueueMessagePublisher;
import com.revature.book.intercom.UserServiceClient;
import org.springframework.stereotype.Service;
import sun.awt.X11.XQueryTree;

@Service
public class BookService {

    private final UserServiceClient userClient;
    private final QueueMessagePublisher queueMessagePublisher;

    public BookService(UserServiceClient userClient, QueueMessagePublisher queueMessagePublisher) {
        this.userClient = userClient;
        this.queueMessagePublisher = queueMessagePublisher;

    }

    @HystrixCommand(fallbackMethod = "serviceUnavailable")
    public String testFeignClient(String test) {
        return userClient.testFeignClient();
    }

    public void sendMessageToQueue() {
        queueMessagePublisher.send(new QueueMessage("This is a message from the book-service!"));
    }

    public String serviceUnavailable(String test) {
        return "The requested service is unavailable at this time, please try again later. Original arg: " + test;
    }

}
