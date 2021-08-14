package com.maxtattoo.service;

import com.maxtattoo.database.repository.*;
import com.maxtattoo.exception.DateFormatException;
import com.maxtattoo.exception.IllegalStateException;
import com.maxtattoo.exception.NullPointerException;
import com.maxtattoo.exception.ResourceNotFoundException;
import com.maxtattoo.pojo.entity.OrderType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.sql.Date;

import static com.maxtattoo.utils.ErrorMessage.START_DATE_GREATER_THEN_END_DATE;

@Service
public class DataValidatorService extends GenericService {

    private final String REQUEST_PARAMETER = "Request parameter ";

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private LocationCityRepository locationCityRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderTypeRepository orderTypeRepository;

    public Long clientIdValidation(Long clientId) {
        if(clientId != null && clientRepository.existsById(clientId)){
            return clientId;
        } else {
            String message = REQUEST_PARAMETER+"clientId("+clientId+") not found! Insert an existing client id.";
            logger.warn(message);
            throw new ResourceNotFoundException(message, HttpStatus.NOT_FOUND);
        }
    }

    public Long orderIdValidation(Long orderId) {
        if(orderId != null && orderRepository.existsById(orderId)){
            return orderId;
        } else {
            String message = REQUEST_PARAMETER+"orderId("+orderId+") not found! Insert an existing client id.";
            logger.warn(message);
            throw new ResourceNotFoundException(message, HttpStatus.NOT_FOUND);
        }
    }

    public OrderType orderTypeValidation(String orderType){
        if (orderType != null && orderTypeRepository.orderTypeExistsByValue(orderType) != null){
            return orderTypeRepository.findOrderTypeByValue(orderType);
        } else {
            String message = "Order type ("+orderType+") not found! Insert an existing order type.";
            logger.warn(message);
            throw new ResourceNotFoundException(message, HttpStatus.NOT_FOUND);
        }
    }

    public String sittingStateValidation(String sittingState){
        if(sittingState == null){
            String message = "The state is null! Sitting state con not be null.";
            logger.info(message);
            throw new NullPointerException(message, HttpStatus.NOT_ACCEPTABLE);
        }

        if(sittingState.equals(StateEnum.TO_DO.getValue()) || sittingState.equals(StateEnum.FINISHED.getValue())){
            return sittingState;
        } else {
            String message = "Illegal state ("+sittingState+") for Sitting!";
            logger.info(message);
            throw new IllegalStateException(message, HttpStatus.NOT_ACCEPTABLE);
        }
    }

    public void startDateNotGreaterThenEndDateValidation(Date startDate, Date endDate){
        if(startDate.after(endDate)){
            String message = START_DATE_GREATER_THEN_END_DATE.getValue();
            logger.warn(message);
            throw new DateFormatException(message, HttpStatus.NOT_ACCEPTABLE);
        }
    }
}
