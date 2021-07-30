package com.maxtattoo.service;

import com.maxtattoo.database.entity.Paint;
import com.maxtattoo.database.repository.PaintRepository;
import com.maxtattoo.exception.ResourceNotFoundException;
import com.maxtattoo.model.PaintModel;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import static com.maxtattoo.utils.ErrorMessages.FIND_BY_ID;

@Service
public class PaintService extends GenericService{

    private static final String ENTITY_NAME = Paint.class.getSimpleName();

    @Autowired
    private PaintRepository paintRepository;

    public PaintModel findById(Long id){
        var result = paintRepository.findById(id);

        if(result.isPresent())
            return super.modelBuilder.createPaintModel(result.get());
        else
            throw new ResourceNotFoundException(FIND_BY_ID.getValue().concat(super.buildEntityId(ENTITY_NAME, id)));
    }
}
