package com.maxtattoo.service;

import com.maxtattoo.database.repository.OrderRepository;
import com.maxtattoo.model.OrderModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService extends GenericService{

    @Autowired
    private OrderRepository orderRepository;


    public OrderModel findOrderById(Long id){
        var order = orderRepository.findOrderById(id);
        return super.modelBuilder.createOrderModel(order);
    }

}
