package com.maxtattoo.service.statisticmanager;

import com.maxtattoo.database.repository.OrderRepository;
import com.maxtattoo.dto.statistic.OrderStatisticModel;
import com.maxtattoo.dto.statistic.TotalStatisticWrapper;
import com.maxtattoo.factory.AbstractFactory;
import com.maxtattoo.factory.FactoryProducer;
import com.maxtattoo.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
public class OrdersStatisticCalculusService extends GenericService {

    @Autowired
    private OrderRepository orderRepository;

    private final AbstractFactory factory = FactoryProducer.getFactory("StatisticFactory");

    public void calculateOrdersTotalStatistic(TotalStatisticWrapper statistic, Date startDate, Date endDate){
        Integer totalOrdersNumber = orderRepository.calculateOrdersTotalNumber(startDate, endDate, null);
        Integer totalOrdersPrice = orderRepository.calculateOrdersTotalPrice(startDate, endDate, null);

        statistic.getOrdersStatistic().setTotalOrders(totalOrdersNumber);
        statistic.getOrdersStatistic().setTotalPrice(totalOrdersPrice);
    }

    public OrderStatisticModel calculateOrdersStatisticByType(Date startDate, Date endDate, String orderType) {
        OrderStatisticModel orderStatistic = (OrderStatisticModel) factory.getObject("OrderStatisticModel");
        Integer totalOrdersNumberByOrderType = orderRepository.calculateOrdersTotalNumber(startDate, endDate, orderType);
        Integer totalOrdersPriceByOrderType = orderRepository.calculateOrdersTotalPrice(startDate, endDate, orderType);

        orderStatistic.setOrderType(orderType);
        orderStatistic.setTotalOrders(totalOrdersNumberByOrderType);
        orderStatistic.setTotalPrice(totalOrdersPriceByOrderType);

        return orderStatistic;
    }
}
