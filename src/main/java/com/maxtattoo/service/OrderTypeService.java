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

import static com.maxtattoo.utils.ErrorMessage.FIND_BY_ID;

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

        if(result.isPresent())
            return super.modelBuilder.createOrderTypeModel(result.get());
        else
            throw new ResourceNotFoundException(super.buildErrorMessage(FIND_BY_ID, id), HttpStatus.NOT_FOUND);
    }

    public List<OrderTypeModel> findAllOrderTypes(){
        var orderTypes = orderTypeRepository.findAll();
        return listModelBuilder.createOrderTypeModel(orderTypes);
    }

    public OrderTypeModel saveOrderType(OrderType entity){
        entity = orderTypeRepository.save(entity);
        return super.modelBuilder.createOrderTypeModel(entity);
    }
}
