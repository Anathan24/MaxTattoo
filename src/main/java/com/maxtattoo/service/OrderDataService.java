package com.maxtattoo.service;

import com.maxtattoo.database.repository.ClientRepository;
import com.maxtattoo.dto.entity.Order;
import com.maxtattoo.dto.entity.OrderType;
import com.maxtattoo.dto.entity.Sitting;
import com.maxtattoo.dto.request.OrderRequest;
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
    private ClientRepository clientRepository;
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
        entity.setClientId(idValidatorService.entityIdValidation(clientRepository, request.getClientId()));

        if(request.getOrderId() == null) {
            entity.setOrderState(OrderState.findByValue(request.getOrderState()) == null ? OrderState.PREVIEW.getValue() : request.getOrderState());
        } else {
            idValidatorService.entityIdValidation(orderRepository, entity.getOrderId());
            checkForNoStateRegression(entity.getOrderId(), entity.getOrderState());
            checkForFinishedOrderState(entity);
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
            Order order = orderRepository.getById(entity.getOrderId());

            int alreadyPaid = entity.getPrepayment();
            for(Sitting sitting : order.getSittings()) {
                alreadyPaid += sitting.getPaid();
            }

            if(entity.getOrderPrice() > alreadyPaid) {
                String message = "The order price("+entity.getOrderPrice()+") is greater then already paid("+alreadyPaid+")!";
                logger.warn(message);
                throw new OrderPriceGreaterThenAlreadyPaidException(message, HttpStatus.NOT_ACCEPTABLE);
            }

            int sittingNumber = order.getSittings().size();
            int avgSittingCost = alreadyPaid/sittingNumber;

            entity.setAlreadyPaid(alreadyPaid);
            entity.setSittingNumber(sittingNumber);
            entity.setAvgSittingCost(avgSittingCost);
            entity.setOrderPrice(alreadyPaid);
        }
    }
}
