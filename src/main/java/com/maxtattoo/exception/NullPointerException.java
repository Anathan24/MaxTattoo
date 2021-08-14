package com.maxtattoo.exception;

import org.springframework.http.HttpStatus;

public class NullPointerException extends GenericException{

    public NullPointerException(String message, HttpStatus status) {
        super(message, status);
    }
}
