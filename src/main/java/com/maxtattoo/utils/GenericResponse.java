package com.maxtattoo.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public enum GenericResponse {

    OK("OK"),
    KO("KO");

    private String value;
}
