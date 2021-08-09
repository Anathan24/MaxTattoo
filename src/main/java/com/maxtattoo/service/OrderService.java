package com.maxtattoo.service;

import com.maxtattoo.database.repository.OrderRepository;
import com.maxtattoo.exception.ResourceNotFoundException;
import com.maxtattoo.pojo.model.OrderModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class OrderService extends GenericService{

    @Autowired
    private OrderRepository orderRepository;

    public OrderModel findById(Long id){
        var result = orderRepository.findById(id);
        logger.info("{}: {}", ENTITY, result);

        if(result.isPresent()) {
            return super.modelBuilder.createOrderModel(result.get());
        }else{
            String message = super.buildEntityNotFoundErrorMessage(id);
            logger.warn(message);
            throw new ResourceNotFoundException(message, HttpStatus.NOT_FOUND);
        }
    }
}
