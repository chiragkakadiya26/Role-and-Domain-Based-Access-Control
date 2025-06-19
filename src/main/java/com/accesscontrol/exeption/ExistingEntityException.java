package com.accesscontrol.exeption;

public class ExistingEntityException extends RuntimeException{

    public ExistingEntityException(String message) {
        super(message);
    }
}