package com.maxtattoo.service;

import com.maxtattoo.database.repository.NeedleRepository;
import com.maxtattoo.exception.ResourceNotFoundException;
import com.maxtattoo.model.NeedleModel;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import static com.maxtattoo.utils.ErrorMessage.FIND_BY_ID;

@Service
public class NeedleService extends GenericService{

    @Autowired
    private NeedleRepository needleRepository;

    public NeedleModel findById(Long id){
        var result = needleRepository.findById(id);

        if(result.isPresent())
            return super.modelBuilder.createNeedleModel(result.get());
        else
            throw new ResourceNotFoundException(super.buildErrorMessage(FIND_BY_ID, id), HttpStatus.NOT_FOUND);
    }
}
