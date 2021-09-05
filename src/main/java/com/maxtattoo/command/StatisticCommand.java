package com.maxtattoo.command;

import com.maxtattoo.database.repository.OrderTypeRepository;
import com.maxtattoo.dto.model.OrderTypeModel;
import com.maxtattoo.dto.statistic.MonthOfYearStatisticModel;
import com.maxtattoo.dto.statistic.OrderStatisticModel;
import com.maxtattoo.dto.statistic.TotalStatisticWrapper;
import com.maxtattoo.factory.AbstractFactory;
import com.maxtattoo.factory.FactoryProducer;
import com.maxtattoo.service.statisticmanager.OrderStatisticCalculusService;
import com.maxtattoo.service.statisticmanager.ClientStatisticCalculusService;
import com.maxtattoo.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

@Component
@Scope("prototype")
public class StatisticCommand extends GenericCommand {

    @Autowired
    private ClientStatisticCalculusService clientStatisticCalculusService;
    @Autowired
    private OrderStatisticCalculusService orderStatisticCalculusService;

    @Autowired
    private FindAllCmd findAll;
    @Autowired
    private OrderTypeRepository orderTypeRepository;

    private final AbstractFactory factory = FactoryProducer.getFactory("StatisticFactory");

    public TotalStatisticWrapper getStatisticByPeriod(String startDate, String endDate) {
        Date start = DateUtils.getDateFromString(startDate);
        Date end = DateUtils.getDateFromString(endDate);
        DateUtils.checkForStartDateNoGreaterThenEndDate(start, end);

        final TotalStatisticWrapper statistic = new TotalStatisticWrapper();
        var orderTypes = findAll.execute(orderTypeRepository, OrderTypeModel.class);
        var statisticByOrderType = new LinkedList<OrderStatisticModel>();

        orderTypes.forEach(type -> statisticByOrderType.add(orderStatisticCalculusService.calculateOrdersStatisticByType(start, end, type.getValue())));

        clientStatisticCalculusService.calculateClientsTotalStatistic(statistic, start, end);
        orderStatisticCalculusService.calculateOrdersTotalStatistic(statistic, start, end);
        statistic.getOrdersStatistic().setOrdersStatisticByOrderType(statisticByOrderType);

        return statistic;
    }

    public List<MonthOfYearStatisticModel> getStatisticByYear(String year){
        int validatedYear = DateUtils.validateYearFormat(year);
        List<MonthOfYearStatisticModel> yearStatistic = new LinkedList<>();

        for(int i = 1; i <= 12; i++) {
            MonthOfYearStatisticModel monthStatistic = (MonthOfYearStatisticModel) factory.getObject("MonthOfYearStatisticModel");
            LocalDate firstMonthDay = LocalDate.of(validatedYear, i, 1);
            LocalDate lastMonthDay = LocalDate.of(validatedYear, i, firstMonthDay.lengthOfMonth());

            monthStatistic.setMonth(firstMonthDay.getMonth().toString());
            monthStatistic.setTotalClientsNumber(clientStatisticCalculusService.calculateTotalClientsNumber(Date.valueOf(firstMonthDay), Date.valueOf(lastMonthDay)));
            monthStatistic.setTotalOrdersNumber(orderStatisticCalculusService.calculateTotalOrdersNumber(Date.valueOf(firstMonthDay), Date.valueOf(lastMonthDay)));
            monthStatistic.setTotalOrdersPrice(orderStatisticCalculusService.calculateTotalOrdersPrice(Date.valueOf(firstMonthDay), Date.valueOf(lastMonthDay)));

            yearStatistic.add(monthStatistic);
        }
        return yearStatistic;
    }
}
