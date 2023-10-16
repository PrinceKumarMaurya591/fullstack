package com.fullstack.exception;

public class MaxResendLimitException extends Exception {

    public MaxResendLimitException(String message) {
        super(message); // Call the constructor of the parent class with the message
    }
}
