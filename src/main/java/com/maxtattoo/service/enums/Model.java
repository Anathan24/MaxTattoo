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

    CITY_MODEL("CityModel"),
    LOCATION_MODEL("LocationModel"),
    CLIENT_MODEL("ClientModel"),
    ORDER_MODEL("OrderModel"),
    ORDER_TYPE_MODEL( "OrderTypeModel"),
    SITTING_MODEL("SittingModel"),
    PAINT_MODEL("PaintModel"),
    NEEDLE_MODEL("NeedleModel");

    private String modelName;

    public static Model findByModelName(String modelName) {
        return Optional.ofNullable(modelName)
                .flatMap(v -> Arrays.stream(values())
                        .filter(el -> Objects.equals(v, el.getModelName()))
                        .findFirst()
                ).orElseThrow(() -> new IllegalArgumentException("Not found model with specified value: "+modelName));
    }
}
