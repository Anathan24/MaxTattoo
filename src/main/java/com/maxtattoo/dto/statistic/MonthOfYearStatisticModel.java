package com.maxtattoo.dto.statistic;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class MonthOfYearStatisticModel implements StatisticObject {

    private String month;
    private Integer totalClientsNumber;
    private Integer totalOrdersNumber;
    private Integer totalOrdersPrice;
}
