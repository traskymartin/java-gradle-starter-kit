package com.example.geektrust.exceptions;


public class ProcessingException extends RuntimeException {
    public ProcessingException() {
        super();
    }

    public ProcessingException(String message) {
        super(message);
    }
}