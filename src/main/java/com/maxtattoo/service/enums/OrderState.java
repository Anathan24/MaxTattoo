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
public enum OrderState {

    PREVIEW(1, GenericState.PREVIEW.getValue()),
    TO_DO(2, GenericState.TO_DO.getValue()),
    IN_PROGRESS(3, GenericState.IN_PROGRESS.getValue()),
    FINISHED(4, GenericState.FINISHED.getValue());

    private Integer position;
    private String value;

    public static OrderState findByPosition(Integer position) {
        return Optional.ofNullable(position)
                .flatMap(v -> Arrays.stream(values())
                        .filter(el -> Objects.equals(v, el.getPosition()))
                        .findFirst()
                ).orElse(null);
    }

    public static OrderState findByValue(String value) {
        return Optional.ofNullable(value)
                .flatMap(v -> Arrays.stream(values())
                        .filter(el -> Objects.equals(v, el.getValue()))
                        .findFirst()
                ).orElse(null);
    }
}
