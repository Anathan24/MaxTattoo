package com.maxtattoo.command;

import com.maxtattoo.database.repository.*;
import com.maxtattoo.exception.ResourceNotFoundException;
import com.maxtattoo.pojo.EntityFactory;
import com.maxtattoo.pojo.entity.Sitting;
import com.maxtattoo.pojo.model.SittingModel;
import com.maxtattoo.pojo.request.SittingRequest;
import com.maxtattoo.service.DataValidator;
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
    private DataValidator dataValidator;

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

        entity.setDate(DateUtils.getTimestampFromString(request.getDate()));
        entity.setSittingState(dataValidator.stateValidation(request.getSittingState()));
        entity.setOrderId(dataValidator.orderIdValidation(request.getOrderId()));

        logger.info("{}: {}", ENTITY, entity);
        entity = sittingRepository.save(entity);
        return super.modelBuilder.createSittingModel(entity);
    }

}
