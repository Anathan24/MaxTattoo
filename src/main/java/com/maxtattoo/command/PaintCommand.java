package com.maxtattoo.command;

import com.maxtattoo.database.repository.PaintRepository;
import com.maxtattoo.exception.ResourceNotFoundException;
import com.maxtattoo.pojo.EntityFactory;
import com.maxtattoo.pojo.entity.Paint;
import com.maxtattoo.pojo.model.PaintModel;
import com.maxtattoo.pojo.request.PaintRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("prototype")
public class PaintCommand extends GenericCommand{

    @Autowired
    private PaintRepository paintRepository;

    public PaintModel findById(Long id){
        var result = paintRepository.findById(id);
        logger.info(MESSAGE_PATTERN, ENTITY, result);

        if(result.isPresent()) {
            return super.modelBuilder.createPaintModel(result.get());
        }else{
            String message = super.buildEntityNotFoundErrorMessage(Paint.class.getSimpleName(), id);
            logger.warn(message);
            throw new ResourceNotFoundException(message, HttpStatus.NOT_FOUND);
        }
    }

    public List<PaintModel> findAll(){
        var result = paintRepository.findAll();
        logger.info(MESSAGE_PATTERN, ENTITY, result);
        return super.listModelBuilder.createPaintModel(result);
    }

    public PaintModel save(PaintRequest request){
        var entity = (Paint) EntityFactory.getEntity(Paint.class.getSimpleName());
        BeanUtils.copyProperties(request, entity);

        logger.info(MESSAGE_PATTERN, ENTITY, entity);
        entity = paintRepository.save(entity);
        return super.modelBuilder.createPaintModel(entity);
    }
}
