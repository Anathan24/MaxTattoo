package com.maxtattoo.service;

import com.maxtattoo.database.repository.*;
import com.maxtattoo.exception.DateFormatException;
import com.maxtattoo.exception.IllegalStateException;
import com.maxtattoo.exception.NullPointerException;
import com.maxtattoo.exception.ResourceNotFoundException;
import com.maxtattoo.bean.entity.OrderType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.sql.Date;

import static com.maxtattoo.utils.ErrorMessage.START_DATE_GREATER_THEN_END_DATE;

@Service
public class DataValidatorService extends GenericService {

    @Autowired
    private OrderTypeRepository orderTypeRepository;

    public OrderType orderTypeValidation(String orderType){
        if (orderType != null && orderTypeRepository.orderTypeExistsByValue(orderType) != null){
            return orderTypeRepository.findOrderTypeByValue(orderType);
        } else {
            String message = "Request parameter orderType("+orderType+") not found! Insert an existing order type.";
            logger.warn(message);
            throw new ResourceNotFoundException(message, HttpStatus.NOT_FOUND);
        }
    }

    public String sittingStateValidation(String sittingState) {
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

    public void startDateNotGreaterThenEndDateValidation(Date startDate, Date endDate) {
        if(startDate.after(endDate)){
            String message = START_DATE_GREATER_THEN_END_DATE.getValue();
            logger.warn(message);
            throw new DateFormatException(message, HttpStatus.NOT_ACCEPTABLE);
        }
    }
}