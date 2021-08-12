package com.maxtattoo.command;

import com.maxtattoo.database.repository.LocationRepository;
import com.maxtattoo.exception.ResourceNotFoundException;
import com.maxtattoo.pojo.entity.Location;
import com.maxtattoo.pojo.model.LocationModel;
import com.maxtattoo.pojo.request.LocationRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class LocationCommand extends GenericCommand {

    @Autowired
    private LocationRepository locationRepository;

    public LocationModel findById(Long id){
        var result = locationRepository.findById(id);
        logger.info("{}: {}", ENTITY, result);

        if(result.isPresent()) {
            return super.modelBuilder.createLocationModel(result.get());
        }else{
            String message = super.buildEntityNotFoundErrorMessage(Location.class.getSimpleName(), id);
            logger.warn(message);
            throw new ResourceNotFoundException(message, HttpStatus.NOT_FOUND);
        }
    }

    public LocationModel saveLocation(LocationRequest request){
        var entity = new Location();
        BeanUtils.copyProperties(request, entity);

        logger.info("{}: {}", ENTITY, entity);
        entity = locationRepository.save(entity);
        return super.modelBuilder.createLocationModel(entity);
    }
}
