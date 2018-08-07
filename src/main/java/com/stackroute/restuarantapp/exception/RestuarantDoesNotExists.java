package com.stackroute.restuarantapp.exception;

public class RestuarantDoesNotExists extends Exception {

    String message;

    public RestuarantDoesNotExists(String message) {
        super(message);
        this.message = message;
    }
}
