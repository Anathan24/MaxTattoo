package com.maxtattoo.exception.supportclasses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

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
