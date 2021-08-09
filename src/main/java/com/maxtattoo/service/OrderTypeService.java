package com.maxtattoo.service;

import com.maxtattoo.builder.ListModelBuilder;
import com.maxtattoo.pojo.entity.OrderType;
import com.maxtattoo.database.repository.OrderTypeRepository;
import com.maxtattoo.database.repository.StateRepository;
import com.maxtattoo.exception.ResourceNotFoundException;
import com.maxtattoo.pojo.model.OrderTypeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderTypeService extends GenericService{

    @Autowired
    private OrderTypeRepository orderTypeRepository;
    @Autowired
    private StateRepository stateRepository;
    @Autowired
    private ListModelBuilder listModelBuilder;

    public OrderTypeModel findById(Long id){
        var result = orderTypeRepository.findById(id);
        logger.info("{}: {}", ENTITY, result);

        if(result.isPresent()) {
            return super.modelBuilder.createOrderTypeModel(result.get());
        }else{
            String message = super.buildEntityNotFoundErrorMessage(id);
            logger.warn(message);
            throw new ResourceNotFoundException(message, HttpStatus.NOT_FOUND);
        }
    }

    public List<OrderTypeModel> findAllOrderTypes(){
        var orderTypes = orderTypeRepository.findAll();
        return listModelBuilder.createOrderTypeModel(orderTypes);
    }

    public OrderTypeModel saveOrderType(OrderType entity){
        logger.info("{}: {}", ENTITY, entity);
        entity = orderTypeRepository.save(entity);
        return super.modelBuilder.createOrderTypeModel(entity);
    }
}
