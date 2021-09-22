package com.maxtattoo.service;

import com.maxtattoo.database.repository.CollectionRepository;
import com.maxtattoo.database.repository.OrderTypeRepository;
import com.maxtattoo.dto.entity.Collection;
import com.maxtattoo.dto.entity.OrderType;
import com.maxtattoo.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetEntityIfExistsService extends GenericService{

    @Autowired
    private CollectionRepository collectionRepository;
    @Autowired
    private OrderTypeRepository orderTypeRepository;

    public Collection isImageExistsOrReturnNull(Long imageId) {
        if(imageId != null && collectionRepository.existsById(imageId)){
            Optional<Collection> image = collectionRepository.findById(imageId);
            return image.orElseThrow();
        }
        return null;
    }

    public OrderType isOrderTypeExistsOrTrowException(String orderType) {
        if (orderType != null && orderTypeRepository.orderTypeExistsByValue(orderType) != null) {
            return orderTypeRepository.findOrderTypeByValue(orderType);
        } else {
            String message = "Request parameter orderType("+orderType+") not found! Insert an existing order type.";
            logger.warn(message);
            throw new ResourceNotFoundException(message, HttpStatus.NOT_FOUND);
        }
    }
}
