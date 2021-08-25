package com.maxtattoo.dto.statistic;

import com.maxtattoo.factory.FactoryProducer;
import lombok.*;

@Data
@ToString
@EqualsAndHashCode
public class TotalStatisticWrapper implements StatisticObject {

    private final ClientStatisticModel clientsStatistic =
            (ClientStatisticModel) FactoryProducer.getFactory("StatisticFactory").getObject("ClientStatisticModel");

    private final TotalOrdersStatisticWrapper ordersStatistic =
            (TotalOrdersStatisticWrapper) FactoryProducer.getFactory("StatisticFactory").getObject("TotalOrdersStatisticWrapper");
}
