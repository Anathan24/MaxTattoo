package com.maxtattoo.service.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

@Getter
@ToString
@AllArgsConstructor
public enum EntityName {

    CITY("City"),
    LOCATION("Location"),
    CLIENT("Client"),
    ORDER("Order"),
    ORDER_TYPE("OrderType"),
    SITTING("Sitting"),
    PAINT("Paint"),
    NEEDLE("Needle");

    private String value;

    public static EntityName findByValue(String value) {
        return Optional.ofNullable(value)
                .flatMap(v -> Arrays.stream(values())
                        .filter(el -> Objects.equals(v, el.getValue()))
                        .findFirst()
                ).orElseThrow(() -> new IllegalArgumentException("Not found entity with specified value: "+value));
    }
}
