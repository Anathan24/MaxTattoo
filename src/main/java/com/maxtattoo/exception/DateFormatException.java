package com.maxtattoo.exception;

import org.springframework.http.HttpStatus;

public class DateFormatException extends GenericException{

    public DateFormatException(String message, HttpStatus status) {
        super(message, status);
    }
}
