package com.maxtattoo.service;

import com.maxtattoo.database.repository.NeedleRepository;
import com.maxtattoo.exception.ResourceNotFoundException;
import com.maxtattoo.pojo.entity.Needle;
import com.maxtattoo.pojo.model.NeedleModel;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class NeedleService extends GenericService{

    @Autowired
    private NeedleRepository needleRepository;

    public NeedleModel findById(Long id){
        var result = needleRepository.findById(id);
        logger.info("{}: {}", ENTITY, result);

        if(result.isPresent()) {
            return super.modelBuilder.createNeedleModel(result.get());
        }else{
            String message = super.buildEntityNotFoundErrorMessage(id);
            logger.warn(message);
            throw new ResourceNotFoundException(message, HttpStatus.NOT_FOUND);
        }
    }

    public NeedleModel saveNeedle(Needle entity){
        logger.info("{}: {}", ENTITY, entity);
        entity = needleRepository.save(entity);
        return super.modelBuilder.createNeedleModel(entity);
    }
}
