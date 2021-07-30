package com.revature.bookstore.exceptions;

public class invalidRequestException extends RuntimeException {

    public invalidRequestException(String message) {
        super(message);
    }
}
