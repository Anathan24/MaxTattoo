package com.maxtattoo.exception;

import org.springframework.http.HttpStatus;

public class OrderPriceGreaterThenAlreadyPaidException extends GenericException{

    public OrderPriceGreaterThenAlreadyPaidException(String message, HttpStatus status) {
        super(message, status);
    }
}
