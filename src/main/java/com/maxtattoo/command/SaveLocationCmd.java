package com.maxtattoo.command;

import com.maxtattoo.database.repository.CityRepository;
import com.maxtattoo.database.repository.LocationCityRepository;
import com.maxtattoo.database.repository.LocationRepository;
import com.maxtattoo.dto.entity.Location;
import com.maxtattoo.dto.entity.LocationCity;
import com.maxtattoo.dto.model.LocationModel;
import com.maxtattoo.dto.request.LocationRequest;
import com.maxtattoo.service.IdValidatorService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.maxtattoo.utils.StringUtils.ENTITY;
import static com.maxtattoo.utils.StringUtils.MESSAGE_PATTERN;

@Component
@Scope("prototype")
public class SaveLocationCmd extends GenericCommand {

    @Autowired
    private LocationRepository locationRepository;
    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private LocationCityRepository locationCityRepository;

    @Autowired
    private IdValidatorService idValidatorService;

    public LocationModel execute(LocationRequest request, List<Long> cities){
        var entity = (Location) entityFactory.getObject(Location.class.getSimpleName());
        BeanUtils.copyProperties(request, entity);

        logger.info(MESSAGE_PATTERN, ENTITY, entity);
        entity = locationRepository.save(entity);
        saveLocationCityRelation(entity.getLocationId(), cities);
        return modelBuilder.buildModel(entity, LocationModel.class);
    }

    private void saveLocationCityRelation(Long locationId, List<Long> cities) {
        if (cities != null) {
            cities.forEach(city -> idValidatorService.entityIdValidation(cityRepository, city));
            cities.forEach(cityId -> {
                var entity = (LocationCity) entityFactory.getObject(LocationCity.class.getSimpleName());
                entity.setLocationIdFk(locationId);
                entity.setCityIdFk(cityId);
                locationCityRepository.save(entity);
            });
        }
    }
}
