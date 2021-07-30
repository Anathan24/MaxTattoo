package com.maxtattoo.service;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorMessages {

    FIND_BY_ID("findById does not found any record for entity: ");

    private final String value;

}
