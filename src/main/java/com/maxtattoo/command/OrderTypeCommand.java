package com.maxtattoo.command;

import com.maxtattoo.builder.ListModelBuilder;
import com.maxtattoo.database.repository.OrderTypeRepository;
import com.maxtattoo.database.repository.StateRepository;
import com.maxtattoo.exception.ResourceNotFoundException;
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
    @Autowired
    private ListModelBuilder listModelBuilder;

    public OrderTypeModel findById(Long id){
        var result = orderTypeRepository.findById(id);
        logger.info("{}: {}", ENTITY, result);

        if(result.isPresent()) {
            return super.modelBuilder.createOrderTypeModel(result.get());
        }else{
            String message = super.buildEntityNotFoundErrorMessage(OrderType.class.getSimpleName(), id);
            logger.warn(message);
            throw new ResourceNotFoundException(message, HttpStatus.NOT_FOUND);
        }
    }

    public OrderTypeModel saveOrderType(OrderTypeRequest request){
        var entity = new OrderType();
        BeanUtils.copyProperties(request, entity);

        logger.info("{}: {}", ENTITY, entity);
        entity = orderTypeRepository.save(entity);
        return super.modelBuilder.createOrderTypeModel(entity);
    }

    //TODO da valutare se creare il service per l'entità orderType
    public List<OrderTypeModel> findAllOrderTypes(){
        var orderTypes = orderTypeRepository.findAll();
        return listModelBuilder.createOrderTypeModel(orderTypes);
    }
}
