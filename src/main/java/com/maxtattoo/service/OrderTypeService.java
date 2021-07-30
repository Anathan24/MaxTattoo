package com.maxtattoo.service;

import com.maxtattoo.database.entity.OrderType;
import com.maxtattoo.database.repository.OrderTypeRepository;
import com.maxtattoo.exception.ResourceNotFoundException;
import com.maxtattoo.model.OrderTypeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.maxtattoo.utils.ErrorMessages.FIND_BY_ID;

@Service
public class OrderTypeService extends GenericService{

    private static final String ENTITY_NAME = OrderType.class.getSimpleName();

    @Autowired
    private OrderTypeRepository orderTypeRepository;

    public OrderTypeModel findById(Long id){
        var result = orderTypeRepository.findById(id);

        if(result.isPresent())
            return super.modelBuilder.createOrderTypeModel(result.get());
        else
            throw new ResourceNotFoundException(FIND_BY_ID.getValue().concat(super.buildEntityId(ENTITY_NAME, id)));
    }

    public OrderTypeModel findOrderTypeByType(String type){
        var orderType = orderTypeRepository.findOrderTypeByType(type);
        return super.modelBuilder.createOrderTypeModel(orderType);
    }

    public List<OrderTypeModel> findAllOrderTypes(){
        var orderTypes = orderTypeRepository.findAll();
        return super.modelBuilder.createOrderTypeModel(orderTypes);
    }
}
