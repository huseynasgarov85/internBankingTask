package com.example.internbankingtask.globalExceptionHandler.exceptions;

public class InvalidOtp extends RuntimeException {
    public InvalidOtp(String message) {
        super(message);
    }
}
