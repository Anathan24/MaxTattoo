package com.maxtattoo.command;

import com.maxtattoo.exception.DateFormatException;
import com.maxtattoo.model.statistic.TotalStatisticWrapper;
import com.maxtattoo.service.OrderTypeService;
import com.maxtattoo.service.statistic.OrdersStatisticCalculusService;
import com.maxtattoo.service.statistic.TotalClientsCalculusService;
import com.maxtattoo.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.sql.Date;

import static com.maxtattoo.utils.ErrorMessages.START_DATE_GREATER_THEN_END_DATE;

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

        if(start.after(end)){
            throw new DateFormatException(START_DATE_GREATER_THEN_END_DATE.getValue(), HttpStatus.NOT_ACCEPTABLE);
        }

        final TotalStatisticWrapper statistic = new TotalStatisticWrapper();
        totalClientsCalculusService.calculateClientsTotalStatistic(statistic, start, end);
        ordersStatisticCalculusService.calculateOrdersTotalStatistic(statistic, start, end);

        var orderTypes = orderTypeService.findAllOrderTypes();
        var orderStatistic = statistic.getOrdersStatistic().getOrdersStatisticByType();

        orderTypes.forEach(type -> orderStatistic.add(ordersStatisticCalculusService.calculateOrdersStatisticByType(start, end, type.getValue())));

        return statistic;
    }
}
