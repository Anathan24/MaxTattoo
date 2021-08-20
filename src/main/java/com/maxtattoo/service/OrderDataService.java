package com.maxtattoo.service;

import com.maxtattoo.bean.entity.Order;
import com.maxtattoo.bean.entity.OrderType;
import com.maxtattoo.bean.entity.Sitting;
import com.maxtattoo.bean.request.OrderRequest;
import com.maxtattoo.database.repository.OrderRepository;
import com.maxtattoo.database.repository.OrderTypeRepository;
import com.maxtattoo.exception.IllegalStateException;
import com.maxtattoo.exception.OrderPriceGreaterThenAlreadyPaidException;
import com.maxtattoo.exception.ResourceNotFoundException;
import com.maxtattoo.service.enums.OrderState;
import com.maxtattoo.utils.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
public class OrderDataService{

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderTypeRepository orderTypeRepository;

    @Autowired
    private IdValidatorService idValidatorService;

    public Order orderDataValidation(OrderRequest request, Order entity) {
        Date startDate = DateUtils.getDateFromString(request.getStartDate());
        Date endEnd = DateUtils.getDateFromString( request.getEndDate());
        DateUtils.checkForStartDateNoGreaterThenEndDate(startDate, endEnd);
        entity.setStartDate(startDate);
        entity.setEndDate(endEnd);
        entity.setOrderType(orderTypeValidation(request.getOrderType()));
        entity.setClientId(idValidatorService.clientIdValidation(request.getClientId()));

        if(request.getOrderId() == null) {
            entity.setOrderState(OrderState.findByValue(request.getOrderState()) == null ? OrderState.PREVIEW.getValue() : request.getOrderState());
        } else {
            idValidatorService.orderIdValidation(entity.getOrderId());
            checkForNoStateRegression(entity.getOrderId(), entity.getOrderState());
            cheForFinishedOrderState(entity, entity.getOrderState());
        }

        return entity;
    }

    public OrderType orderTypeValidation(String orderType) {
        if (orderType != null && orderTypeRepository.orderTypeExistsByValue(orderType) != null){
            return orderTypeRepository.findOrderTypeByValue(orderType);
        } else {
            String message = "Request parameter orderType("+orderType+") not found! Insert an existing order type.";
            logger.warn(message);
            throw new ResourceNotFoundException(message, HttpStatus.NOT_FOUND);
        }
    }

    public void checkForNoStateRegression(Long orderId, String orderState) {
        Order lastOrderVersion = orderRepository.getById(orderId);
        OrderState newState = OrderState.findByValue(orderState);
        OrderState oldState = OrderState.findByValue(lastOrderVersion.getOrderState());

        if(oldState.getPosition() > newState.getPosition()) {
            String message = "The Order state regression is verified! New order state can not be ("+newState.getValue()+"), because old order state is ("+oldState.getValue()+")";
            logger.warn(message);
            throw new IllegalStateException(message, HttpStatus.NOT_ACCEPTABLE);
        }
    }

    public void cheForFinishedOrderState(Order entity, String orderState) {
        OrderState state = OrderState.findByValue(orderState);

        if(state.equals(OrderState.FINISHED)){
            Order order = orderRepository.getById(entity.getOrderId());

            int alreadyPaid = 0;
            for(Sitting sitting : order.getSittings()){
                alreadyPaid += Integer.sum(alreadyPaid, sitting.getPaid());
            }

            boolean orderPriceGreaterThenAlreadyPaid = order.getOrderPrice() > alreadyPaid;
            if(orderPriceGreaterThenAlreadyPaid){
                String message = "The order price is greater then already paid!";
                logger.warn(message);
                throw new OrderPriceGreaterThenAlreadyPaidException(message, HttpStatus.NOT_ACCEPTABLE);
            }

            entity.setAlreadyPaid(alreadyPaid);
            entity.setSittingNumber(order.getSittings().size());
            entity.setAvgSittingCost((double)alreadyPaid/order.getSittings().size());
        }
    }
}
