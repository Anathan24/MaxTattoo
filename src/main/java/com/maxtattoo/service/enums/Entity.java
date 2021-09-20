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
public enum Entity {

    CITY("City"),
    LOCATION("Location"),
    LOCATION_CITY("LocationCity"),
    CLIENT("Client"),
    ORDER("Order"),
    ORDER_TYPE("OrderType"),
    SITTING("Sitting"),
    PAINT("Paint"),
    SITTING_PAINT("SittingPaint"),
    NEEDLE("Needle"),
    SITTING_NEEDLE("SittingNeedle"),
    IMAGE("Image");

    private String entityName;

    public static Entity findByEntityName(String modelName) {
        return Optional.ofNullable(modelName)
                .flatMap(v -> Arrays.stream(values())
                        .filter(el -> Objects.equals(v, el.getEntityName()))
                        .findFirst()
                ).orElseThrow(() -> new IllegalArgumentException("Not found entity with specified value: "+modelName));
    }
}
