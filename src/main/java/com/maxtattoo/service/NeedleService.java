package com.maxtattoo.service;

import com.maxtattoo.database.entity.Needle;
import com.maxtattoo.database.repository.NeedleRepository;
import com.maxtattoo.exception.ResourceNotFoundException;
import com.maxtattoo.model.NeedleModel;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import static com.maxtattoo.utils.ErrorMessages.FIND_BY_ID;

@Service
public class NeedleService extends GenericService{

    private static final String ENTITY_NAME = Needle.class.getSimpleName();

    @Autowired
    private NeedleRepository needleRepository;

    public NeedleModel findById(Long id){
        var result = needleRepository.findById(id);

        if(result.isPresent())
            return super.modelBuilder.createNeedleModel(result.get());
        else
            throw new ResourceNotFoundException(FIND_BY_ID.getValue().concat(super.buildEntityId(ENTITY_NAME, id)), HttpStatus.NOT_FOUND);
    }
}
