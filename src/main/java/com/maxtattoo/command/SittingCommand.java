package com.maxtattoo.command;

import com.maxtattoo.database.repository.*;
import com.maxtattoo.exception.ResourceNotFoundException;
import com.maxtattoo.pojo.EntityFactory;
import com.maxtattoo.pojo.entity.Sitting;
import com.maxtattoo.pojo.entity.State;
import com.maxtattoo.pojo.model.SittingModel;
import com.maxtattoo.pojo.request.SittingRequest;
import com.maxtattoo.utils.DateUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class SittingCommand extends GenericCommand {

    @Autowired
    private SittingRepository sittingRepository;
    @Autowired
    private StateRepository stateRepository;
    @Autowired
    private OrderRepository orderRepository;

    public SittingModel findById(Long id) {
        var result = sittingRepository.findById(id);
        logger.info("{}: {}", ENTITY, result);

        if(result.isPresent()) {
            return super.modelBuilder.createSittingModel(result.get());
        }else{
            String message = super.buildEntityNotFoundErrorMessage(Sitting.class.getSimpleName(), id);
            logger.warn(message);
            throw new ResourceNotFoundException(message, HttpStatus.NOT_FOUND);
        }
    }

    public SittingModel save(SittingRequest request) {
        var entity = (Sitting) EntityFactory.getEntity(Sitting.class.getSimpleName());
        BeanUtils.copyProperties(request, entity);
        logger.info("{}: {}", ENTITY, entity);

        //entity.setDate(DateUtils.getTimestampFromString(request.getDate()));
        entity.setSittingState(stateValidation(request.getSittingState()));
        orderIdValidation(request.getOrderId());

        entity = sittingRepository.save(entity);
        return super.modelBuilder.createSittingModel(entity);
    }

    private State stateValidation(String state) {
        if(state != null && stateRepository.stateExists(state) != null) {
            return stateRepository.findStateByValue(state);
        } else {
            String message = REQUEST_PARAMETER+"State ("+state+") not found! Insert an existing state.";
            logger.warn(message);
            throw new ResourceNotFoundException(message, HttpStatus.NOT_FOUND);
        }
    }

    private void orderIdValidation(Long orderId) {
        if(orderId == null || !orderRepository.existsById(orderId)){
            String message = REQUEST_PARAMETER+"orderId("+orderId+") not found! Insert an existing client id.";
            logger.warn(message);
            throw new ResourceNotFoundException(message, HttpStatus.NOT_FOUND);
        }
    }
}
