package com.maxtattoo.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

@Getter
@AllArgsConstructor
public enum OrderType {

    TATTOO("Tattoo"),
    PERMANENT_MAKEUP("Permanent makeup");

    private final String value;

    public static OrderType findByValue(String value){
        return Optional.ofNullable(value).
                flatMap(v -> Arrays.stream(values())
                        .filter(el -> Objects.equals(v, el.getValue()))
                        .findFirst()
                ).orElseThrow(() -> new IllegalArgumentException("Received unexpected OrderType: "+value+"!"));
    }
}
