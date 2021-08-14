package com.maxtattoo.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public abstract class GenericException extends RuntimeException{

    private final HttpStatus status;

    public GenericException(String message, HttpStatus status){
        super(message);
        this.status = status;
    }
}
