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
public enum SittingState {

    TO_DO(1, GenericState.TO_DO.getValue()),
    FINISHED(2, GenericState.FINISHED.getValue());

    private Integer position;
    private String value;

    public static SittingState findByPosition(Integer position) {
        return Optional.ofNullable(position)
                .flatMap(v -> Arrays.stream(values())
                        .filter(el -> Objects.equals(v, el.getPosition()))
                        .findFirst()
                ).orElse(null);
    }

    public static SittingState findByValue(String value) {
        return Optional.ofNullable(value)
                .flatMap(v -> Arrays.stream(values())
                        .filter(el -> Objects.equals(v, el.getValue()))
                        .findFirst()
                ).orElse(null);
    }

}
