package com.maxtattoo.service;

import com.maxtattoo.database.repository.ClientRepository;
import com.maxtattoo.database.repository.OrderRepository;
import com.maxtattoo.database.repository.OrderTypeRepository;
import com.maxtattoo.database.repository.StateRepository;
import com.maxtattoo.exception.DateFormatException;
import com.maxtattoo.exception.ResourceNotFoundException;
import com.maxtattoo.pojo.entity.OrderType;
import com.maxtattoo.pojo.entity.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.sql.Date;

import static com.maxtattoo.utils.ErrorMessage.START_DATE_GREATER_THEN_END_DATE;

@Service
public class DataValidator extends GenericService {

    private final String REQUEST_PARAMETER = "Request parameter ";

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderTypeRepository orderTypeRepository;
    @Autowired
    private StateRepository stateRepository;

    public Long clientIdValidation(Long clientId){
        if(clientId != null && clientRepository.existsById(clientId)){
            return clientId;
        }else{
            String message = REQUEST_PARAMETER+"clientId("+clientId+") not found! Insert an existing client id.";
            logger.warn(message);
            throw new ResourceNotFoundException(message, HttpStatus.NOT_FOUND);
        }
    }

    public Long orderIdValidation(Long orderId) {
        if(orderId != null || orderRepository.existsById(orderId)){
            return orderId;
        }else{
            String message = REQUEST_PARAMETER+"orderId("+orderId+") not found! Insert an existing client id.";
            logger.warn(message);
            throw new ResourceNotFoundException(message, HttpStatus.NOT_FOUND);
        }
    }

    public State stateValidation(String state) {
        if(state != null && stateRepository.stateExists(state) != null) {
            return stateRepository.findStateByValue(state);
        } else {
            String message = REQUEST_PARAMETER+"State ("+state+") not found! Insert an existing state.";
            logger.warn(message);
            throw new ResourceNotFoundException(message, HttpStatus.NOT_FOUND);
        }
    }

    public OrderType orderTypeIdValidation(){
        //TODO da implementare.
        return null;
    }

    public OrderType orderTypeValidation(String orderType){
        if (orderType != null && orderTypeRepository.orderTypeExists(orderType) != null){
            return orderTypeRepository.findOrderTypeByValue(orderType);
        } else {
            String message = "Order type "+orderType+" not found! Insert an existing order type.";
            logger.warn(message);
            throw new ResourceNotFoundException(message, HttpStatus.NOT_FOUND);
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
