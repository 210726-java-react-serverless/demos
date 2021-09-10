package com.revature.user.intercom;

import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

@Component
public class QueueListener {

    @SqsListener("my-queue")
    public void receiveMessage(String message, @Header("SenderId") String senderId) {
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("MESSAGE RECEIVED FROM: " + senderId);
        System.out.println("MESSAGE PAYLOAD: " + message);
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
    }

}
