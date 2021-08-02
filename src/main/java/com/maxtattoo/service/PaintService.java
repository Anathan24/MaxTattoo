package com.maxtattoo.service;

import com.maxtattoo.database.repository.PaintRepository;
import com.maxtattoo.exception.ResourceNotFoundException;
import com.maxtattoo.model.PaintModel;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import static com.maxtattoo.utils.ErrorMessage.FIND_BY_ID;

@Service
public class PaintService extends GenericService{

    @Autowired
    private PaintRepository paintRepository;

    public PaintModel findById(Long id){
        var result = paintRepository.findById(id);

        if(result.isPresent())
            return super.modelBuilder.createPaintModel(result.get());
        else
            throw new ResourceNotFoundException(super.buildErrorMessage(FIND_BY_ID, id), HttpStatus.NOT_FOUND);
    }
}
