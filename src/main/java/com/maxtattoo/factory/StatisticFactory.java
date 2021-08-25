package com.maxtattoo.factory;

import com.maxtattoo.dto.GenericObject;
import com.maxtattoo.dto.statistic.ClientStatisticModel;
import com.maxtattoo.dto.statistic.OrderStatisticModel;
import com.maxtattoo.dto.statistic.TotalOrdersStatisticWrapper;
import com.maxtattoo.dto.statistic.TotalStatisticWrapper;

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

            default: throw new IllegalArgumentException("Model with name "+objectSimpleName+" does not exist");
        }
    }
}
