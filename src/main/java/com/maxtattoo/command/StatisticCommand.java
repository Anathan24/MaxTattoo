package com.maxtattoo.command;

import com.maxtattoo.model.statistic.TotalStatisticWrapper;
import com.maxtattoo.service.OrderTypeService;
import com.maxtattoo.service.statistic.OrdersStatisticCalculusService;
import com.maxtattoo.service.statistic.TotalClientsCalculusService;
import com.maxtattoo.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Component
@Scope("prototype")
public class StatisticCommand extends GenericCommand{

    @Autowired
    private TotalClientsCalculusService totalClientsCalculusService;
    @Autowired
    private OrdersStatisticCalculusService ordersStatisticCalculusService;
    @Autowired
    private OrderTypeService orderTypeService;

    public TotalStatisticWrapper calculateStatisticByPeriod(String startDate, String endDate){
        Date start = DateUtils.getDateFromString(startDate);
        Date end = DateUtils.getDateFromString(endDate);
        if(start.after(end)){ throw new IllegalArgumentException("The start date can not be greater then end date!"); }

        final TotalStatisticWrapper statistic = new TotalStatisticWrapper();
        totalClientsCalculusService.calculateClientsTotalStatistic(statistic, start, end);
        ordersStatisticCalculusService.calculateOrdersTotalStatistic(statistic, start, end);

        var orderTypes = orderTypeService.findAllOrderTypes();
        var orderStatistic = statistic.getOrdersStatistic().getOrdersStatisticByType();

        orderTypes.forEach(type -> orderStatistic.add(ordersStatisticCalculusService.calculateOrdersStatisticByType(type.getValue(), start, end)));

        return statistic;
    }
}
