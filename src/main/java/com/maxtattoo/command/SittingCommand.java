package com.maxtattoo.command;

import com.maxtattoo.database.repository.SittingNeedleRepository;
import com.maxtattoo.database.repository.SittingPaintRepository;
import com.maxtattoo.database.repository.SittingRepository;
import com.maxtattoo.exception.ResourceNotFoundException;
import com.maxtattoo.pojo.entity.Sitting;
import com.maxtattoo.pojo.model.SittingModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class SittingCommand extends GenericCommand{

    @Autowired
    private SittingRepository sittingRepository;
    @Autowired
    private SittingNeedleRepository sittingNeedleRepository;
    @Autowired
    private SittingPaintRepository sittingPaintRepository;

    public SittingModel findById(Long id){
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
}
