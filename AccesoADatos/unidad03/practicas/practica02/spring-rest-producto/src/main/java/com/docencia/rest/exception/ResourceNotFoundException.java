package com.docencia.rest.exception;

public class ResourceNotFoundException extends Exception {

    public ResourceNotFoundException() {
        super();
    }

    public ResourceNotFoundException(String mensaje) {
        super(mensaje);
    }

    public ResourceNotFoundException(String mensaje, Throwable myExcetion) {
        super(mensaje, myExcetion);
    }
}
