package com.revature.exceptions;

public class UnrecognizedOperatorException extends RuntimeException {

    public UnrecognizedOperatorException() {
        super("Unrecognized operator specified!");
    }

}
