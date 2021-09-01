package com.revature.spring_mvc.exceptions;

public class InvalidRequestException extends RuntimeException {
    public InvalidRequestException() {
        super("The request was invalid.");
    }
}
