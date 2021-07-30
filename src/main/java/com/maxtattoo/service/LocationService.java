package com.maxtattoo.service;

import com.maxtattoo.database.entity.Location;
import com.maxtattoo.database.repository.LocationRepository;
import com.maxtattoo.exception.ResourceNotFoundException;
import com.maxtattoo.model.LocationModel;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import static com.maxtattoo.utils.ErrorMessages.FIND_BY_ID;

@Service
public class LocationService extends GenericService{

    private static final String ENTITY_NAME = Location.class.getSimpleName();

    @Autowired
    private LocationRepository locationRepository;

    public LocationModel findById(Long id){
        var result = locationRepository.findById(id);

        if(result.isPresent())
            return super.modelBuilder.createLocationModel(result.get());
        else
            throw new ResourceNotFoundException(FIND_BY_ID.getValue().concat(super.buildEntityId(ENTITY_NAME, id)));
    }
}
