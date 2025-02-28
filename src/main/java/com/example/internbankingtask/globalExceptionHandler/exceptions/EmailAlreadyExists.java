package com.example.internbankingtask.globalExceptionHandler.exceptions;

public class EmailAlreadyExists extends RuntimeException {

    public EmailAlreadyExists(String message) {
        super(message);
    }
}
