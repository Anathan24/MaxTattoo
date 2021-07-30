package com.maxtattoo.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import org.springframework.http.HttpStatus;

import java.util.Date;

@Data
@ToString
@AllArgsConstructor
public class ExceptionResponseMessage {

    private String date;
    private int statusCode;
    private String statusMessage;
    private String details;
    private String path;

}
