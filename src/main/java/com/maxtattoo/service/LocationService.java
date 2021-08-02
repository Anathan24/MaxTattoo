package com.maxtattoo.service;

import com.maxtattoo.database.repository.LocationRepository;
import com.maxtattoo.exception.ResourceNotFoundException;
import com.maxtattoo.model.LocationModel;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import static com.maxtattoo.utils.ErrorMessage.FIND_BY_ID;

@Service
public class LocationService extends GenericService{

    @Autowired
    private LocationRepository locationRepository;

    public LocationModel findById(Long id){
        var result = locationRepository.findById(id);

        if(result.isPresent())
            return super.modelBuilder.createLocationModel(result.get());
        else
            throw new ResourceNotFoundException(super.buildErrorMessage(FIND_BY_ID, id), HttpStatus.NOT_FOUND);
    }
}
