package com.maxtattoo.command;

import com.maxtattoo.exception.DateFormatException;
import com.maxtattoo.pojo.statistic.TotalStatisticWrapper;
import com.maxtattoo.service.OrdersStatisticCalculusService;
import com.maxtattoo.service.TotalClientsCalculusService;
import com.maxtattoo.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.sql.Date;

import static com.maxtattoo.utils.ErrorMessage.START_DATE_GREATER_THEN_END_DATE;

@Component
@Scope("prototype")
public class StatisticCommand extends GenericCommand{

    @Autowired
    private TotalClientsCalculusService totalClientsCalculusService;
    @Autowired
    private OrdersStatisticCalculusService ordersStatisticCalculusService;
    @Autowired
    private OrderTypeCommand orderTypeCommand;

    public TotalStatisticWrapper calculateStatisticByPeriod(String startDate, String endDate){
        Date start = DateUtils.getDateFromString(startDate);
        Date end = DateUtils.getDateFromString(endDate);

        if(start.after(end)){
            String message = START_DATE_GREATER_THEN_END_DATE.getValue();
            logger.warn(message);
            throw new DateFormatException(message, HttpStatus.NOT_ACCEPTABLE);
        }

        final TotalStatisticWrapper statistic = new TotalStatisticWrapper();
        totalClientsCalculusService.calculateClientsTotalStatistic(statistic, start, end);
        ordersStatisticCalculusService.calculateOrdersTotalStatistic(statistic, start, end);

        var orderTypes = orderTypeCommand.findAllOrderTypes();
        var orderStatistic = statistic.getOrdersStatistic().getOrdersStatisticByType();

        orderTypes.forEach(type -> orderStatistic.add(ordersStatisticCalculusService.calculateOrdersStatisticByType(start, end, type.getValue())));

        return statistic;
    }
}
