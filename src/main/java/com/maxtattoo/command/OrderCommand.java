package com.maxtattoo.command;

import com.maxtattoo.database.repository.OrderRepository;
import com.maxtattoo.exception.ResourceNotFoundException;
import com.maxtattoo.pojo.entity.Order;
import com.maxtattoo.pojo.model.OrderModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class OrderCommand extends GenericCommand {

    @Autowired
    private OrderRepository orderRepository;

    public OrderModel findById(Long id){
        var result = orderRepository.findById(id);
        logger.info("{}: {}", ENTITY, result);

        if(result.isPresent()) {
            return super.modelBuilder.createOrderModel(result.get());
        }else{
            String message = super.buildEntityNotFoundErrorMessage(Order.class.getSimpleName(), id);
            logger.warn(message);
            throw new ResourceNotFoundException(message, HttpStatus.NOT_FOUND);
        }
    }

}
