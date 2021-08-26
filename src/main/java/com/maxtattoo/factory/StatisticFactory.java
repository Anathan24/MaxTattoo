package com.maxtattoo.factory;

import com.maxtattoo.dto.GenericObject;
import com.maxtattoo.dto.statistic.*;

public class StatisticFactory implements AbstractFactory {

    @Override
    public GenericObject getObject(String objectSimpleName) {

        switch(objectSimpleName){
            case "OrderStatisticModel":
                return new OrderStatisticModel();
            case "ClientStatisticModel":
                return new ClientStatisticModel();
            case "TotalOrdersStatisticWrapper":
                return new TotalOrdersStatisticWrapper();
            case "TotalStatisticWrapper":
                return new TotalStatisticWrapper();
            case "MonthOfYearStatisticModel":
                return new MonthOfYearStatisticModel();

            default: throw new IllegalArgumentException("Model with name "+objectSimpleName+" does not exist");
        }
    }
}
