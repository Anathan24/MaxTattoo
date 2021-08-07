package com.maxtattoo.service;

import com.maxtattoo.database.repository.OrderRepository;
import com.maxtattoo.exception.ResourceNotFoundException;
import com.maxtattoo.pojo.model.OrderModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import static com.maxtattoo.utils.ErrorMessage.FIND_BY_ID;

@Service
public class OrderService extends GenericService{

    @Autowired
    private OrderRepository orderRepository;

    public OrderModel findById(Long id){
        var result = orderRepository.findById(id);

        if(result.isPresent())
            return super.modelBuilder.createOrderModel(result.get());
        else
            throw new ResourceNotFoundException(super.buildErrorMessage(FIND_BY_ID, id), HttpStatus.NOT_FOUND);
    }
}
