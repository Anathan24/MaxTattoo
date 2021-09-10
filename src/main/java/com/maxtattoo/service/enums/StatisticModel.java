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
public enum StatisticModel {

    ORDER_STATISTIC_MODEL("OrderStatisticModel"),
    CLIENT_STATISTIC_MODEL("ClientStatisticModel"),
    TOTAL_STATISTIC_MODEL("TotalOrdersStatisticWrapper"),
    TOTAL_STATISTIC_WRAPPER("TotalStatisticWrapper"),
    MONTH_OF_YEAR_STATISTIC_MODEL("MonthOfYearStatisticModel");

    private String statisticModelName;

    public static StatisticModel findByStatisticModelName(String statisticModelName) {
        return Optional.ofNullable(statisticModelName)
                .flatMap(v -> Arrays.stream(values())
                        .filter(el -> Objects.equals(v, el.getStatisticModelName()))
                        .findFirst()
                ).orElseThrow(() -> new IllegalArgumentException("Statistic model not found with specified value: "+statisticModelName));
    }

}
