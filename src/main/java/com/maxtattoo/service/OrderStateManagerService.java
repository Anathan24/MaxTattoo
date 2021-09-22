package com.maxtattoo.service;

import com.maxtattoo.dto.entity.Order;
import com.maxtattoo.dto.entity.Sitting;
import com.maxtattoo.database.repository.OrderRepository;
import com.maxtattoo.exception.IllegalStateException;
import com.maxtattoo.exception.OrderPriceGreaterThenAlreadyPaidException;
import com.maxtattoo.service.enums.OrderState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderStateManagerService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private OrderRepository orderRepository;

    public void checkForNoStateRegression(Long orderId, String orderState) {
        Order lastOrderVersion = getPreviousOrderState(orderId);
        OrderState oldState = OrderState.findByValue(lastOrderVersion.getOrderState());
        OrderState newState = OrderState.findByValue(orderState);

        if(oldState.getPosition() > newState.getPosition()) {
            String message = "The Order state regression is verified! New order state can not be ("+newState.getValue()+"), because old order state is ("+oldState.getValue()+")";
            logger.warn(message);
            throw new IllegalStateException(message, HttpStatus.NOT_ACCEPTABLE);
        }
    }

    public void checkForFinishedOrderState(Order entity) {
        OrderState state = OrderState.findByValue(entity.getOrderState());

        if(state.equals(OrderState.FINISHED)) {
            Order order = getPreviousOrderState(entity.getOrderId());

            int avgSittingCost = 0;
            int sittingNumber = order.getSittings().size();
            int alreadyPaid = entity.getPrepayment();

            for(Sitting sitting : order.getSittings()) {
                alreadyPaid += sitting.getPaid();
            }

            checkOrderPriceIsNotGreaterThenAlreadyPaid(entity.getOrderPrice(), alreadyPaid);

            if(sittingNumber != 0 )
                avgSittingCost = alreadyPaid/sittingNumber;

            entity.setAlreadyPaid(alreadyPaid);
            entity.setSittingNumber(sittingNumber);
            entity.setAvgSittingCost(avgSittingCost);
            entity.setOrderPrice(alreadyPaid);
        }
    }

    private Order getPreviousOrderState(Long orderId) {
       Optional<Order> order = orderRepository.findById(orderId);
        return order.orElseThrow();
    }

    private void checkOrderPriceIsNotGreaterThenAlreadyPaid(Integer orderPrice, int alreadyPaid){
        if(orderPrice > alreadyPaid) {
            String message = "The order price("+orderPrice+") is greater then already paid("+alreadyPaid+")!";
            logger.warn(message);
            throw new OrderPriceGreaterThenAlreadyPaidException(message, HttpStatus.NOT_ACCEPTABLE);
        }
    }
}
