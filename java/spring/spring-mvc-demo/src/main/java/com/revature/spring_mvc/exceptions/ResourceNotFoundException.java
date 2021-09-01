package com.revature.spring_mvc.exceptions;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException() {
        super("No resource found with the provided search parameters.");
    }
}
