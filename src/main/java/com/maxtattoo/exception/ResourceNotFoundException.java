package com.maxtattoo.exception;

import org.springframework.http.HttpStatus;

public class ResourceNotFoundException extends GenericException {

    public ResourceNotFoundException(String message, HttpStatus status) {
        super(message, status);
    }
}
