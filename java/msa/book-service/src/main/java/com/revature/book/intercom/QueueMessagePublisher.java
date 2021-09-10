package com.revature.book.intercom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
public class QueueMessagePublisher {

    private final QueueMessagingTemplate queueMessagingTemplate;

    @Value("${app.queue-name}")
    private String queueName;

    @Autowired
    public QueueMessagePublisher(QueueMessagingTemplate queueMessagingTemplate) {
        this.queueMessagingTemplate = queueMessagingTemplate;
    }

    public void send(Object message) {
        queueMessagingTemplate.convertAndSend(queueName, message);
    }

}
