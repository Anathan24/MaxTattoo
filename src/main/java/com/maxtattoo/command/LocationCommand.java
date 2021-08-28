package com.maxtattoo.command;

import com.maxtattoo.database.repository.LocationCityRepository;
import com.maxtattoo.database.repository.LocationRepository;
import com.maxtattoo.dto.entity.Location;
import com.maxtattoo.dto.entity.LocationCity;
import com.maxtattoo.dto.model.LocationModel;
import com.maxtattoo.dto.request.LocationRequest;
import com.maxtattoo.service.DeleteForeignKeyService;
import com.maxtattoo.service.IdValidatorService;
import com.maxtattoo.utils.GenericResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
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

    public LocationModel save(LocationRequest request, List<Long> cities){
        var entity = (Location) entityFactory.getObject(Location.class.getSimpleName());
        BeanUtils.copyProperties(request, entity);

        logger.info(MESSAGE_PATTERN, ENTITY, entity);
        entity = locationRepository.save(entity);
        saveLocationCityRelation(entity.getLocationId(), cities);
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
            cities.forEach(city -> idValidatorService.cityIdValidation(city));
            cities.forEach(cityId -> {
                var entity = (LocationCity) entityFactory.getObject(LocationCity.class.getSimpleName());
                entity.setLocationIdFk(locationId);
                entity.setCityIdFk(cityId);
                locationCityRepository.save(entity);
            });
        }
    }
}
