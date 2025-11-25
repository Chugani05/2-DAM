package com.docencia.rest.exeception;

public class ResourceNotFoundException extends Exception {

    public ResourceNotFoundException(String message) {
        super(message);
    }

    public ResourceNotFoundException(String message, Throwable myException) {
        super(message, myException);
    }
}
