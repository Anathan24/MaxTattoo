package com.maxtattoo.service;

import com.maxtattoo.database.repository.OrderTypeRepository;
import com.maxtattoo.model.OrderTypeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderTypeService extends GenericService{

    @Autowired
    private OrderTypeRepository orderTypeRepository;

    public OrderTypeModel findOrderTypeById(Long id){
        var orderType = orderTypeRepository.findOrderTypeById(id);
        return super.modelBuilder.createOrderTypeModel(orderType);
    }

    public OrderTypeModel findOrderTypeByType(String type){
        var orderType = orderTypeRepository.findOrderTypeByType(type);
        return super.modelBuilder.createOrderTypeModel(orderType);
    }
}
