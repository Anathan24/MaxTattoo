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
    private LocationRepository locationRepository;
    @Autowired
    private LocationCityRepository locationCityRepository;
    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private SittingRepository sittingRepository;
    @Autowired
    private PaintRepository paintRepository;
    @Autowired
    private NeedleRepository needleRepository;
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

    public Long locationIdValidation(Long locationId){
        if(locationRepository.existsById(locationId)){
            return locationId;
        } else {
            String message = REQUEST_PARAMETER+"locationId("+locationId+") not found! Insert an existing location id.";
            logger.warn(message);
            throw new ResourceNotFoundException(message, HttpStatus.NOT_FOUND);
        }
    }

    public Long cityIdValidation(Long cityId){
        if(cityId != null && cityRepository.existsById(cityId)){
            return cityId;
        } else {
            String message = REQUEST_PARAMETER+"cityId("+cityId+") not found! Insert an existing city id.";
            logger.warn(message);
            throw new ResourceNotFoundException(message, HttpStatus.NOT_FOUND);
        }
    }

    public Long orderIdValidation(Long orderId) {
        if(orderId != null && orderRepository.existsById(orderId)){
            return orderId;
        } else {
            String message = REQUEST_PARAMETER+"orderId("+orderId+") not found! Insert an existing order id.";
            logger.warn(message);
            throw new ResourceNotFoundException(message, HttpStatus.NOT_FOUND);
        }
    }

    public Long orderTypeIdValidation(Long orderTypeId){
        if(orderTypeId != null && orderTypeRepository.existsById(orderTypeId)){
            return orderTypeId;
        } else {
            String message = REQUEST_PARAMETER+"orderTypeId("+orderTypeId+") not found! Insert an existing order type id.";
            logger.warn(message);
            throw new ResourceNotFoundException(message, HttpStatus.NOT_FOUND);
        }
    }

    public OrderType orderTypeValidation(String orderType){
        if (orderType != null && orderTypeRepository.orderTypeExistsByValue(orderType) != null){
            return orderTypeRepository.findOrderTypeByValue(orderType);
        } else {
            String message = REQUEST_PARAMETER+ "orderType("+orderType+") not found! Insert an existing order type.";
            logger.warn(message);
            throw new ResourceNotFoundException(message, HttpStatus.NOT_FOUND);
        }
    }

    public Long sittingIdValidation(Long sittingId) {
        if(sittingId != null && sittingRepository.existsById(sittingId)){
            return sittingId;
        } else {
            String message = REQUEST_PARAMETER+ "sittingId("+sittingId+") not found! Insert an existing sitting id.";
            logger.warn(message);
            throw new ResourceNotFoundException(message, HttpStatus.NOT_FOUND);
        }
    }

    public Long paintIdValidation(Long paintId) {
        if(paintId != null && paintRepository.existsById(paintId)){
            return paintId;
        } else {
            String message = REQUEST_PARAMETER+ "paintId("+paintId+") not found! Insert an existing paint id.";
            logger.warn(message);
            throw new ResourceNotFoundException(message, HttpStatus.NOT_FOUND);
        }
    }

    public Long needleIdValidation(Long needleId){
        if(needleId != null && needleRepository.existsById(needleId)) {
            return needleId;
        } else {
            String message = REQUEST_PARAMETER+ "needleId("+needleId+") not found! Insert an existing needle id.";
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
