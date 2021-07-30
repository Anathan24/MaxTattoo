package com.maxtattoo.service.statistic;

import com.maxtattoo.database.repository.OrderRepository;
import com.maxtattoo.model.statistic.OrderStatistic;
import com.maxtattoo.model.statistic.TotalStatisticWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
public class OrdersStatisticCalculusService {

    @Autowired
    private OrderRepository orderRepository;

    public void calculateOrdersTotalStatistic(TotalStatisticWrapper statistic, Date startDate, Date endDate){
        statistic.getOrdersStatistic().setTotalOrders(orderRepository.calculateOrdersTotalNumber(null, startDate, endDate));
        statistic.getOrdersStatistic().setTotalPrice(orderRepository.calculateOrdersTotalPrice(null, startDate, endDate));
    }

    public OrderStatistic calculateOrdersStatisticByType(String orderType, Date startDate, Date endDate){
        OrderStatistic orderStatistic = new OrderStatistic();
        orderStatistic.setOrderType(orderType);
        orderStatistic.setTotalOrders(orderRepository.calculateOrdersTotalNumber(orderType, startDate, endDate));
        orderStatistic.setTotalPrice(orderRepository.calculateOrdersTotalPrice(orderType, startDate, endDate));
        return orderStatistic;
    }
}
