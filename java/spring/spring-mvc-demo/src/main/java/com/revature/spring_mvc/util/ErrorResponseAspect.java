package com.revature.spring_mvc.util;

import com.revature.spring_mvc.dtos.ErrorResponse;
import com.revature.spring_mvc.exceptions.InvalidRequestException;
import com.revature.spring_mvc.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorResponseAspect {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleInvalidRequestException(InvalidRequestException e) { // the exception param is what tells spring exception
        return new ErrorResponse(400, e.getMessage());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleResourceNotFoundException(ResourceNotFoundException e) {
        return new ErrorResponse(404, e.getMessage());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handleOtherExceptions(Exception e) {
        return new ErrorResponse(500, e.getMessage());
    }

}
