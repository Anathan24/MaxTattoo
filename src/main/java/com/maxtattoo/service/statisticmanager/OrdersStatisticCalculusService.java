package com.maxtattoo.service.statisticmanager;

import com.maxtattoo.database.repository.OrderRepository;
import com.maxtattoo.bean.statistic.OrderStatistic;
import com.maxtattoo.bean.statistic.TotalStatisticWrapper;
import com.maxtattoo.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
public class OrdersStatisticCalculusService extends GenericService {

    @Autowired
    private OrderRepository orderRepository;

    public void calculateOrdersTotalStatistic(TotalStatisticWrapper statistic, Date startDate, Date endDate){
        statistic.getOrdersStatistic().setTotalOrders(orderRepository.calculateOrdersTotalNumber(startDate, endDate, null));
        statistic.getOrdersStatistic().setTotalPrice(orderRepository.calculateOrdersTotalPrice(startDate, endDate, null));
    }

    public OrderStatistic calculateOrdersStatisticByType(Date startDate, Date endDate, String orderType){
        OrderStatistic orderStatistic = new OrderStatistic();
        orderStatistic.setOrderType(orderType);
        orderStatistic.setTotalOrders(orderRepository.calculateOrdersTotalNumber(startDate, endDate, orderType));
        orderStatistic.setTotalPrice(orderRepository.calculateOrdersTotalPrice( startDate, endDate, orderType));
        return orderStatistic;
    }
}
