package com.maxtattoo.service.statistic;

import com.maxtattoo.database.repository.OrderRepository;
import com.maxtattoo.model.statistic.OrderStatistic;
import com.maxtattoo.model.statistic.TotalStatisticWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdersStatisticCalculusService {

    @Autowired
    private OrderRepository orderRepository;

    public void calculateOrdersStatistic(TotalStatisticWrapper statistic, String startDate, String endDate){
        Integer totalOrdersNumber = orderRepository.calculateTotalOrdersNumber();
        Integer totalOrderPrice = orderRepository.calculateTotalOrdersPrice();

        statistic.getOrdersStatistic().setTotalOrders(totalOrdersNumber);
        statistic.getOrdersStatistic().setTotalPrice(totalOrderPrice);
    }

    public OrderStatistic calculateOrdersStatisticByType(Long orderId, String type, String startDate, String endDate){
        OrderStatistic orderStatistic = new OrderStatistic();
        orderStatistic.setOrderType(type);
        orderStatistic.setTotalOrders(orderRepository.calculateTotalOrdersNumberByOrderTypeTypeId(orderId));
        orderStatistic.setTotalPrice(orderRepository.calculateTotalOrderPriceByOrderTypeId(orderId));
        return orderStatistic;
    }
}
