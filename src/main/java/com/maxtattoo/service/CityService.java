package com.maxtattoo.service;

import com.maxtattoo.database.repository.CityRepository;
import com.maxtattoo.database.repository.LocationRepository;
import com.maxtattoo.exception.ForeignKeyViolationException;
import com.maxtattoo.exception.ResourceNotFoundException;
import com.maxtattoo.pojo.entity.City;
import com.maxtattoo.pojo.model.CityModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class CityService extends GenericService {

    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private LocationRepository locationRepository;

    public CityModel findById(Long id){
        var result = cityRepository.findById(id);
        logger.info("{}: {}", ENTITY, result);
        if(result.isPresent())
            return super.modelBuilder.createCityModel(result.get());
        else
            throw new ResourceNotFoundException(super.buildEntityNotFoundErrorMessage(id), HttpStatus.NOT_FOUND);
    }

    public CityModel saveCity(City entity){
        logger.info("{}: {}", ENTITY, entity);

        if(!locationRepository.existsById(entity.getLocationId())){
            String message = "locationId does not exist! Insert an existing locationId.";
            logger.error(message);
            throw new ForeignKeyViolationException(message, HttpStatus.NOT_ACCEPTABLE);
        }

        entity = cityRepository.save(entity);
        return super.modelBuilder.createCityModel(entity);
    }
}
