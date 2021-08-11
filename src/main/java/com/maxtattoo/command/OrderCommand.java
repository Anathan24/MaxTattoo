package com.maxtattoo.command;

import com.maxtattoo.database.repository.ClientRepository;
import com.maxtattoo.database.repository.OrderRepository;
import com.maxtattoo.database.repository.OrderTypeRepository;
import com.maxtattoo.database.repository.StateRepository;
import com.maxtattoo.exception.ResourceNotFoundException;
import com.maxtattoo.pojo.EntityFactory;
import com.maxtattoo.pojo.entity.Order;
import com.maxtattoo.pojo.entity.OrderType;
import com.maxtattoo.pojo.entity.State;
import com.maxtattoo.pojo.model.OrderModel;
import com.maxtattoo.pojo.request.OrderRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class OrderCommand extends GenericCommand {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderTypeRepository orderTypeRepository;
    @Autowired
    private StateRepository stateRepository;

    public OrderModel findById(Long id) {
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

    public OrderModel save(OrderRequest request) {
        var entity = (Order) EntityFactory.getEntity(Order.class.getSimpleName());
        BeanUtils.copyProperties(request, entity);
        logger.info("{}: {}", ENTITY, entity);

        clientIdValidation(request.getClientId());
        entity.setOrderType(orderTypeValidation(request.getOrderType()));
        entity.setOrderState(stateValidation(request.getOrderState()));

        entity = orderRepository.save(entity);
        return super.modelBuilder.createOrderModel(entity);
    }

    private void clientIdValidation(Long clientId){
        if(clientId == null || !clientRepository.existsById(clientId)){
            String message = REQUEST_PARAMETER+"clientId("+clientId+") not found! Insert an existing client id.";
            logger.warn(message);
            throw new ResourceNotFoundException(message, HttpStatus.NOT_FOUND);
        }
    }

    private OrderType orderTypeValidation(String orderType){
        if (orderType != null && orderTypeRepository.orderTypeExists(orderType) != null){
            return orderTypeRepository.findOrderTypeByValue(orderType);
        } else {
            String message = "Order type "+orderType+" not found! Insert an existing order type.";
            logger.warn(message);
            throw new ResourceNotFoundException(message, HttpStatus.NOT_FOUND);
        }
    }

    private State stateValidation(String state){
        if(state != null && stateRepository.stateExists(state) != null) {
            return stateRepository.findStateByValue(state);
        } else {
            String message = REQUEST_PARAMETER+"State ("+state+") not found! Insert an existing state.";
            logger.warn(message);
            throw new ResourceNotFoundException(message, HttpStatus.NOT_FOUND);
        }
    }
}
