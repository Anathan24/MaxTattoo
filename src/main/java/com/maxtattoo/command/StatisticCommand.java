package com.maxtattoo.command;

import com.maxtattoo.pojo.statistic.TotalStatisticWrapper;
import com.maxtattoo.service.DataValidatorService;
import com.maxtattoo.service.OrdersStatisticCalculusService;
import com.maxtattoo.service.TotalClientsCalculusService;
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
    private OrderCommand orderCommand;
    @Autowired
    private DataValidatorService dataValidatorService;

    public TotalStatisticWrapper calculateStatisticByPeriod(String startDate, String endDate){
        Date start = DateUtils.getDateFromString(startDate);
        Date end = DateUtils.getDateFromString(endDate);

        dataValidatorService.startDateNotGreaterThenEndDateValidation(start, end);

        final TotalStatisticWrapper statistic = new TotalStatisticWrapper();
        totalClientsCalculusService.calculateClientsTotalStatistic(statistic, start, end);
        ordersStatisticCalculusService.calculateOrdersTotalStatistic(statistic, start, end);

        var orderTypes = orderCommand.findAllOrderTypes();
        var orderStatistic = statistic.getOrdersStatistic().getOrdersStatisticByType();

        orderTypes.forEach(type -> orderStatistic.add(ordersStatisticCalculusService.calculateOrdersStatisticByType(start, end, type.getValue())));

        return statistic;
    }
}
