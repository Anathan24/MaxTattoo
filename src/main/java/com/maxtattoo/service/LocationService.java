package com.maxtattoo.service;

import com.maxtattoo.database.repository.LocationRepository;
import com.maxtattoo.exception.ResourceNotFoundException;
import com.maxtattoo.pojo.entity.Location;
import com.maxtattoo.pojo.model.LocationModel;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class LocationService extends GenericService{

    @Autowired
    private LocationRepository locationRepository;

    public LocationModel findById(Long id){
        var result = locationRepository.findById(id);
        logger.info("{}: {}", ENTITY, result);

        if(result.isPresent()) {
            return super.modelBuilder.createLocationModel(result.get());
        }else{
            String message = super.buildEntityNotFoundErrorMessage(id);
            logger.warn(message);
            throw new ResourceNotFoundException(message, HttpStatus.NOT_FOUND);
        }
    }

    public LocationModel saveLocation(Location entity){
        logger.info("{}: {}", ENTITY, entity);
        entity = locationRepository.save(entity);
        return super.modelBuilder.createLocationModel(entity);

    }
}
