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
public enum GenericState {

    PREVIEW("Preview"),
    TO_DO("To do"),
    IN_PROGRESS("In Progress"),
    FINISHED("Finished");

    private final String value;

    public static GenericState findByValue(String value) {
        return Optional.ofNullable(value)
                .flatMap(v -> Arrays.stream(values())
                        .filter(el -> Objects.equals(v, el.getValue()))
                        .findFirst()
                ).orElse(null);
    }
}
