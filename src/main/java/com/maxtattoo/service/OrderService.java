package com.maxtattoo.service;

import com.maxtattoo.database.entity.Order;
import com.maxtattoo.database.repository.OrderRepository;
import com.maxtattoo.exception.ResourceNotFoundException;
import com.maxtattoo.model.OrderModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.maxtattoo.utils.ErrorMessages.FIND_BY_ID;

@Service
public class OrderService extends GenericService{

    private static final String ENTITY_NAME = Order.class.getSimpleName();

    @Autowired
    private OrderRepository orderRepository;

    public OrderModel findById(Long id){
        var result = orderRepository.findById(id);

        if(result.isPresent())
            return super.modelBuilder.createOrderModel(result.get());
        else
            throw new ResourceNotFoundException(FIND_BY_ID.getValue().concat(super.buildEntityId(ENTITY_NAME, id)));
    }
}
