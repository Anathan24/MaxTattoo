package com.maxtattoo.command;

import com.maxtattoo.builder.ListModelBuilder;
import com.maxtattoo.database.repository.CityRepository;
import com.maxtattoo.database.repository.LocationRepository;
import com.maxtattoo.exception.ResourceNotFoundException;
import com.maxtattoo.pojo.entity.City;
import com.maxtattoo.pojo.model.CityModel;
import com.maxtattoo.pojo.request.CityRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("prototype")
public class CityCommand extends GenericCommand {

    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private LocationRepository locationRepository;

    public CityModel findById(Long id){
        var result = cityRepository.findById(id);
        logger.info(MESSAGE_PATTERN, ENTITY, result);
        if(result.isPresent()) {
            return super.modelBuilder.createCityModel(result.get());
        } else {
            String message = super.buildEntityNotFoundErrorMessage(City.class.getSimpleName(), id);
            logger.warn(message);
            throw new ResourceNotFoundException(message, HttpStatus.NOT_FOUND);
        }
    }

    public List<CityModel> findAll(){
        var result = cityRepository.findAll();
        logger.info(MESSAGE_PATTERN, ENTITY, result);

        return super.listModelBuilder.createCityModel(result);
    }

    public CityModel save(CityRequest request){
        var entity = new City();
        BeanUtils.copyProperties(request, entity);

        logger.info(MESSAGE_PATTERN, ENTITY, entity);
        entity = cityRepository.save(entity);
        return super.modelBuilder.createCityModel(entity);
    }
}
