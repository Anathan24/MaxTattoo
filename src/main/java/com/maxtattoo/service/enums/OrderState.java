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

    PREVIEW(1, "Preview"),
    TO_DO(2, "To do"),
    IN_PROGRESS(3, "In Progress"),
    FINISHED(4,"Finished");

    private Integer position;
    private String value;

    public static OrderState findByValue(String value) {
        return Optional.ofNullable(value)
                .flatMap(v -> Arrays.stream(values())
                        .filter(el -> Objects.equals(v, el.getValue()))
                        .findFirst()
                ).orElse(null);
    }
}
