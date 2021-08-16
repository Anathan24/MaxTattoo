package com.maxtattoo.service;

import com.maxtattoo.database.repository.*;
import com.maxtattoo.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class IdValidatorService extends GenericService {

    private final String REQUEST_PARAMETER = "Request parameter ";

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private LocationRepository locationRepository;
    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderTypeRepository orderTypeRepository;

    @Autowired
    private SittingRepository sittingRepository;
    @Autowired
    private PaintRepository paintRepository;
    @Autowired
    private NeedleRepository needleRepository;


    public Long clientIdValidation(Long clientId) {
        if(clientId != null && clientRepository.existsById(clientId)) {
            return clientId;
        } else {
            String message = REQUEST_PARAMETER+"clientId("+clientId+") not found! Insert an existing client id.";
            this.throwResourceNotFoundException(message);
            return null;
        }
    }

    public Long locationIdValidation(Long locationId) {
        if(locationId != null && locationRepository.existsById(locationId)) {
            return locationId;
        } else {
            String message = REQUEST_PARAMETER+"locationId("+locationId+") not found! Insert an existing location id.";
            this.throwResourceNotFoundException(message);
            return null;
        }
    }

    public Long cityIdValidation(Long cityId) {
        if(cityId != null && cityRepository.existsById(cityId)) {
            return cityId;
        } else {
            String message = REQUEST_PARAMETER+"cityId("+cityId+") not found! Insert an existing city id.";
            this.throwResourceNotFoundException(message);
            return null;
        }
    }


    public Long orderIdValidation(Long orderId) {
        if(orderId != null && orderRepository.existsById(orderId)) {
            return orderId;
        } else {
            String message = REQUEST_PARAMETER+"orderId("+orderId+") not found! Insert an existing order id.";
            this.throwResourceNotFoundException(message);
            return null;
        }
    }

    public Long orderTypeIdValidation(Long orderTypeId) {
        if(orderTypeId != null && orderTypeRepository.existsById(orderTypeId)) {
            return orderTypeId;
        } else {
            String message = REQUEST_PARAMETER+"orderTypeId("+orderTypeId+") not found! Insert an existing order type id.";
            this.throwResourceNotFoundException(message);
            return null;
        }
    }

    public Long sittingIdValidation(Long sittingId) {
        if(sittingId != null && sittingRepository.existsById(sittingId)){
            return sittingId;
        } else {
            String message = REQUEST_PARAMETER+ "sittingId("+sittingId+") not found! Insert an existing sitting id.";
            this.throwResourceNotFoundException(message);
            return null;
        }
    }

    public Long paintIdValidation(Long paintId) {
        if(paintId != null && paintRepository.existsById(paintId)) {
            return paintId;
        } else {
            String message = REQUEST_PARAMETER+ "paintId("+paintId+") not found! Insert an existing paint id.";
            this.throwResourceNotFoundException(message);
            return null;
        }
    }

    public Long needleIdValidation(Long needleId) {
        if(needleId != null && needleRepository.existsById(needleId)) {
            return needleId;
        } else {
            String message = REQUEST_PARAMETER+ "needleId("+needleId+") not found! Insert an existing needle id.";
            this.throwResourceNotFoundException(message);
            return null;
        }
    }

    private void throwResourceNotFoundException(String message){
        logger.info(message);
        throw new ResourceNotFoundException(message, HttpStatus.NOT_FOUND);
    }
}
