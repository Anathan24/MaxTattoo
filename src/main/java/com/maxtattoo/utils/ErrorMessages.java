package com.maxtattoo.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorMessages {

    FIND_BY_ID("findById does not found any record for entity: "),
    START_DATE_GREATER_THEN_END_DATE("The start date can not be greater then end date!"),
    WRONG_DATE_FORMAT("Wrong date format!");

    private final String value;

}
