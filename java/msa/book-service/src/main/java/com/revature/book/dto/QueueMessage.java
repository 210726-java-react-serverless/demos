package com.revature.book.dto;

public class QueueMessage {

    private String payload;

    public QueueMessage() {
        super();
    }

    public QueueMessage(String payload) {
        this.payload = payload;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

}
