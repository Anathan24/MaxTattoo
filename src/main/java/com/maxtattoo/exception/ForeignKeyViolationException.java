package com.maxtattoo.exception;

import org.springframework.http.HttpStatus;

public class ForeignKeyViolationException extends GenericException{

    public ForeignKeyViolationException(String message, HttpStatus status) {
        super(message, status);
    }
}
