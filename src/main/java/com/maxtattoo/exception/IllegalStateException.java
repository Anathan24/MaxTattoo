package com.maxtattoo.exception;

import org.springframework.http.HttpStatus;

public class IllegalStateException extends GenericException{

    public IllegalStateException(String message, HttpStatus status) {
        super(message, status);
    }
}
