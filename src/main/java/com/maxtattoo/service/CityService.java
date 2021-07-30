package com.maxtattoo.service;

import com.maxtattoo.database.repository.CityRepository;
import com.maxtattoo.exception.ResourceNotFoundException;
import com.maxtattoo.model.CityModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.maxtattoo.service.ErrorMessages.FIND_BY_ID;

@Service
public class CityService extends GenericService {

    private static final String ENTITY_NAME = "City";

    @Autowired
    private CityRepository cityRepository;

    public CityModel findById(Long id){
        final String entityId = "("+id+")";
        var result = cityRepository.findById(id);

        if(result.isPresent())
            return super.modelBuilder.createCityModel(result.get());
        else
            throw new ResourceNotFoundException(FIND_BY_ID.getValue().concat(ENTITY_NAME).concat(entityId));
    }

}
