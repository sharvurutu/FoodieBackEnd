package com.stackroute.restuarantapp.exception;

public class RestuarantAlreadyExistException extends Exception {

    String message;

    public RestuarantAlreadyExistException(String message) {
        super(message);
        this.message = message;
    }
}
