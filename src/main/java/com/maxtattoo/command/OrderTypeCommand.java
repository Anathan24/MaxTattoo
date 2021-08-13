package com.maxtattoo.command;

import com.maxtattoo.database.repository.OrderTypeRepository;
import com.maxtattoo.database.repository.StateRepository;
import com.maxtattoo.exception.ResourceNotFoundException;
import com.maxtattoo.pojo.EntityFactory;
import com.maxtattoo.pojo.entity.OrderType;
import com.maxtattoo.pojo.model.OrderTypeModel;
import com.maxtattoo.pojo.request.OrderTypeRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("prototype")
public class OrderTypeCommand extends GenericCommand {

    @Autowired
    private OrderTypeRepository orderTypeRepository;
    @Autowired
    private StateRepository stateRepository;

    public OrderTypeModel findById(Long id){
        var result = orderTypeRepository.findById(id);
        logger.info(MESSAGE_PATTERN, ENTITY, result);

        if(result.isPresent()) {
            return super.modelBuilder.createOrderTypeModel(result.get());
        }else{
            String message = super.buildEntityNotFoundErrorMessage(OrderType.class.getSimpleName(), id);
            logger.warn(message);
            throw new ResourceNotFoundException(message, HttpStatus.NOT_FOUND);
        }
    }

    public OrderTypeModel save(OrderTypeRequest request){
        var entity = (OrderType) EntityFactory.getEntity(OrderType.class.getSimpleName());
        BeanUtils.copyProperties(request, entity);

        logger.info(MESSAGE_PATTERN, ENTITY, entity);
        entity = orderTypeRepository.save(entity);
        return super.modelBuilder.createOrderTypeModel(entity);
    }

    public List<OrderTypeModel> findAll(){
        var result = orderTypeRepository.findAll();
        logger.info(MESSAGE_PATTERN, ENTITY, result);
        return listModelBuilder.createOrderTypeModel(result);
    }
}
