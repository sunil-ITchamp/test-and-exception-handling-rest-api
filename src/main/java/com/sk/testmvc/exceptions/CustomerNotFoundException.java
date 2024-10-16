package com.sk.testmvc.exceptions;

public class CustomerNotFoundException extends RuntimeException{

    public CustomerNotFoundException() {
        super("Customer search has Failed..");
    }
}
