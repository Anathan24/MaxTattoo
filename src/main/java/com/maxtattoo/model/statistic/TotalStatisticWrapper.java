package com.maxtattoo.model.statistic;

import lombok.*;

@Data
@ToString
@EqualsAndHashCode
public class TotalStatisticWrapper {

    private final TotalClientWrapper clientsStatistic = new TotalClientWrapper();
    private final TotalOrdersWrapper ordersStatistic = new TotalOrdersWrapper();

}
