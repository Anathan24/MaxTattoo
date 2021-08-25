package com.maxtattoo.command;

import com.maxtattoo.dto.statistic.OrderStatisticModel;
import com.maxtattoo.dto.statistic.TotalStatisticWrapper;
import com.maxtattoo.service.statisticmanager.OrdersStatisticCalculusService;
import com.maxtattoo.service.statisticmanager.TotalClientsCalculusService;
import com.maxtattoo.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.LinkedList;

@Component
@Scope("prototype")
public class StatisticCommand extends GenericCommand {

    @Autowired
    private TotalClientsCalculusService totalClientsCalculusService;
    @Autowired
    private OrdersStatisticCalculusService ordersStatisticCalculusService;
    @Autowired
    private OrderCommand orderCommand;

    public TotalStatisticWrapper calculateStatisticByPeriod(String startDate, String endDate) {
        Date start = DateUtils.getDateFromString(startDate);
        Date end = DateUtils.getDateFromString(endDate);
        DateUtils.checkForStartDateNoGreaterThenEndDate(start, end);

        final TotalStatisticWrapper statistic = new TotalStatisticWrapper();
        var orderTypes = orderCommand.findAllOrderTypes();
        var statisticByOrderType = new LinkedList<OrderStatisticModel>();

        orderTypes.forEach(type -> statisticByOrderType.add(ordersStatisticCalculusService.calculateOrdersStatisticByType(start, end, type.getValue())));

        totalClientsCalculusService.calculateClientsTotalStatistic(statistic, start, end);
        ordersStatisticCalculusService.calculateOrdersTotalStatistic(statistic, start, end);
        statistic.getOrdersStatistic().setOrdersStatisticByType(statisticByOrderType);

        return statistic;
    }
}
