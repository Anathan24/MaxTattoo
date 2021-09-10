package com.maxtattoo.factory;

import com.maxtattoo.dto.GenericObject;
import com.maxtattoo.dto.statistic.*;
import com.maxtattoo.service.enums.StatisticModel;

public class StatisticFactory implements AbstractFactory {

    @Override
    public GenericObject getObject(String objectSimpleName) {
        StatisticModel statisticModel = StatisticModel.findByStatisticModelName(objectSimpleName);

        switch(statisticModel){
            case ORDER_STATISTIC_MODEL:
                return new OrderStatisticModel();
            case CLIENT_STATISTIC_MODEL:
                return new ClientStatisticModel();
            case TOTAL_STATISTIC_MODEL:
                return new TotalOrdersStatisticWrapper();
            case TOTAL_STATISTIC_WRAPPER:
                return new TotalStatisticWrapper();
            case MONTH_OF_YEAR_STATISTIC_MODEL:
                return new MonthOfYearStatisticModel();

            default: throw new IllegalArgumentException("Model with name "+objectSimpleName+" does not exist");
        }
    }
}
