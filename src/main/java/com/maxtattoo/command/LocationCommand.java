package com.maxtattoo.command;

import com.maxtattoo.database.repository.LocationCityRepository;
import com.maxtattoo.database.repository.LocationRepository;
import com.maxtattoo.exception.ResourceNotFoundException;
import com.maxtattoo.pojo.EntityFactory;
import com.maxtattoo.pojo.entity.Location;
import com.maxtattoo.pojo.entity.LocationCity;
import com.maxtattoo.pojo.model.LocationModel;
import com.maxtattoo.pojo.request.LocationRequest;
import com.maxtattoo.service.DataValidatorService;
import com.maxtattoo.service.DeleteForeignKeyRelationService;
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
    private DataValidatorService dataValidatorService;
    @Autowired
    private DeleteForeignKeyRelationService deleteForeignKeyRelationService;

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

    public List<LocationModel> findAll(){
        var result = locationRepository.findAll();
        logger.info(MESSAGE_PATTERN, ENTITY, result);
        return super.listModelBuilder.createLocationModel(result);
    }

    public LocationModel save(LocationRequest request, List<Long> cities){
        var entity = (Location) EntityFactory.getEntity(Location.class.getSimpleName());
        BeanUtils.copyProperties(request, entity);

        logger.info(MESSAGE_PATTERN, ENTITY, entity);
        entity = locationRepository.save(entity);
        saveLocationCityRelation(entity.getId(), cities);
        return super.modelBuilder.createLocationModel(entity);
    }

    public String deleteById(Long locationId){
        if(locationRepository.existsById(locationId)){
            deleteForeignKeyRelationService.deleteLocationCityRelationByLocationId(locationId);
            deleteForeignKeyRelationService.deleteClientLocationRelationByLocationId(locationId);
            locationRepository.deleteById(locationId);
            return "OK";
        } else {
            return "KO"+" - Location with id("+locationId+") does not exist!";
        }
    }

    public void saveLocationCityRelation(Long locationId, List<Long> cities) {
        if (cities != null) {
            cities.forEach(cityId -> {
                var entity = (LocationCity) EntityFactory.getEntity(LocationCity.class.getSimpleName());
                entity.setLocationId(locationId);
                entity.setCityId(cityId);
                locationCityRepository.save(entity);
            });
        }
    }
}
