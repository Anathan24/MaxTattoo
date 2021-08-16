package com.maxtattoo.command;

import com.maxtattoo.database.repository.LocationCityRepository;
import com.maxtattoo.database.repository.LocationRepository;
import com.maxtattoo.exception.ResourceNotFoundException;
import com.maxtattoo.bean.entity.Location;
import com.maxtattoo.bean.entity.LocationCity;
import com.maxtattoo.bean.model.LocationModel;
import com.maxtattoo.bean.request.LocationRequest;
import com.maxtattoo.service.DeleteForeignKeyService;
import com.maxtattoo.service.IdValidatorService;
import com.maxtattoo.utils.GenericResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("prototype")
public class LocationCommand extends GenericCommand {

    @Autowired
    private LocationRepository locationRepository;
    @Autowired
    private LocationCityRepository locationCityRepository;

    @Autowired
    private IdValidatorService idValidatorService;
    @Autowired
    private DeleteForeignKeyService deleteForeignKeyService;

    public LocationModel findById(Long id){
        var result = locationRepository.findById(id);
        logger.info(MESSAGE_PATTERN, ENTITY, result);

        if(result.isPresent()) {
            return super.modelBuilder.createLocationModel(result.get());
        }else{
            String message = super.buildEntityNotFoundErrorMessage(Location.class.getSimpleName(), id);
            logger.warn(message);
            throw new ResourceNotFoundException(message, HttpStatus.NOT_FOUND);
        }
    }

    public List<LocationModel> findAll() {
        var result = locationRepository.findAll();
        logger.info(MESSAGE_PATTERN, ENTITY, result);
        return super.listModelBuilder.createListLocationModel(result);
    }

    public LocationModel save(LocationRequest request, List<Long> cities){
        var entity = (Location) entityFactory.getObject(Location.class.getSimpleName());
        BeanUtils.copyProperties(request, entity);

        logger.info(MESSAGE_PATTERN, ENTITY, entity);
        entity = locationRepository.save(entity);
        saveLocationCityRelation(entity.getId(), cities);
        return super.modelBuilder.createLocationModel(entity);
    }

    public GenericResponse deleteById(Long id) {
        var locationId = idValidatorService.locationIdValidation(id);
        deleteForeignKeyService.deleteLocationCityRelationByLocationId(locationId);
        deleteForeignKeyService.deleteClientsLocationFk(locationId);
        locationRepository.deleteById(locationId);
        return GenericResponse.OK;
    }

    public void saveLocationCityRelation(Long locationId, List<Long> cities) {
        if (cities != null) {
            cities.forEach(cityId -> {
                var entity = (LocationCity) entityFactory.getObject(LocationCity.class.getSimpleName());
                entity.setLocationIdFk(locationId);
                entity.setCityIdFk(cityId);
                locationCityRepository.save(entity);
            });
        }
    }
}
