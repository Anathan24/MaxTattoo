package com.maxtattoo.service;

import com.maxtattoo.database.repository.PaintRepository;
import com.maxtattoo.exception.ResourceNotFoundException;
import com.maxtattoo.pojo.entity.Paint;
import com.maxtattoo.pojo.model.PaintModel;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class PaintService extends GenericService{

    @Autowired
    private PaintRepository paintRepository;

    public PaintModel findById(Long id){
        var result = paintRepository.findById(id);
        logger.info("{}: {}", ENTITY, result);

        if(result.isPresent()) {
            return super.modelBuilder.createPaintModel(result.get());
        }else{
            String message = super.buildEntityNotFoundErrorMessage(id);
            logger.warn(message);
            throw new ResourceNotFoundException(message, HttpStatus.NOT_FOUND);
        }
    }

    public PaintModel savePaint(Paint entity){
        logger.info("{}: {}", ENTITY, entity);
        entity = paintRepository.save(entity);
        return super.modelBuilder.createPaintModel(entity);
    }
}
