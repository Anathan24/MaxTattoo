package com.maxtattoo.command;

import com.maxtattoo.model.statistic.TotalStatisticWrapper;
import com.maxtattoo.service.OrderTypeService;
import com.maxtattoo.service.statistic.OrdersStatisticCalculusService;
import com.maxtattoo.service.statistic.TotalClientsCalculusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class StatisticCommand extends GenericCommand{

    private final TotalStatisticWrapper statistic = new TotalStatisticWrapper();

    @Autowired
    private TotalClientsCalculusService totalClientsCalculusService;
    @Autowired
    private OrdersStatisticCalculusService ordersStatisticCalculusService;
    @Autowired
    private OrderTypeService orderTypeService;

    public TotalStatisticWrapper calculateStatisticByPeriod(String startDate, String endDate){

        totalClientsCalculusService.calculateTotalClientsStatistic(statistic, startDate, endDate);
        ordersStatisticCalculusService.calculateOrdersStatistic(statistic, startDate, endDate);

        var orderTypes = orderTypeService.findAllOrderTypes();
        orderTypes.forEach(type -> statistic.getOrdersStatistic().getOrdersStatisticByOrderType()
                .add(ordersStatisticCalculusService.calculateOrdersStatisticByType(type.getId(), type.getValue(),  startDate, endDate)));
        return statistic;
    }
}
