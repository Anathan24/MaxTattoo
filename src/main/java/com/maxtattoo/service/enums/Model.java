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
public enum Model {

    CITY("CityModel"),
    LOCATION("LocationModel"),
    CLIENT("ClientModel"),
    ORDER("OrderModel"),
    ORDER_TYPE( "OrderTypeModel"),
    SITTING("SittingModel"),
    PAINT("PaintModel"),
    NEEDLE("NeedleModel");

    private String modelName;

    public static Model findByModel(String modelName) {
        return Optional.ofNullable(modelName)
                .flatMap(v -> Arrays.stream(values())
                        .filter(el -> Objects.equals(v, el.getModelName()))
                        .findFirst()
                ).orElseThrow(() -> new IllegalArgumentException("Not found model with specified value: "+modelName));
    }
}
