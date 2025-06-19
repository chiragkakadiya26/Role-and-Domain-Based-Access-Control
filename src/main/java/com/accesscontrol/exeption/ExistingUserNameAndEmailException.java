package com.accesscontrol.exeption;

public class ExistingUserNameAndEmailException extends RuntimeException{

    public ExistingUserNameAndEmailException(String message) {
        super(message);
    }
}
