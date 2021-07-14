package com.maxtattoo.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

@AllArgsConstructor
@Getter
public enum StateEnum {

    PREVIEW("PREVIEW"),
    TODO("TODO"),
    IN_PROGRESS("In Progress"),
    FINISHED("Finished");

    private final String value;

    public static StateEnum findByValue(String value) {
        return Optional.ofNullable(value)
                .flatMap(v -> Arrays.stream(values())
                        .filter(el -> Objects.equals(v, el.getValue()))
                        .findFirst()
                ).orElseThrow(() -> new IllegalArgumentException("Unexpected StateEnum state: "+value));
    }
}
