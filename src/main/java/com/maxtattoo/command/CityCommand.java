package com.maxtattoo.command;

import com.maxtattoo.database.repository.CityRepository;
import com.maxtattoo.dto.entity.City;
import com.maxtattoo.dto.model.CityModel;
import com.maxtattoo.dto.request.CityRequest;
import com.maxtattoo.service.DeleteForeignKeyService;
import com.maxtattoo.service.IdValidatorService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class CityCommand extends GenericCommand {

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private IdValidatorService idValidatorService;
    @Autowired
    private DeleteForeignKeyService deleteForeignKeyService;

    public CityModel save(CityRequest request){
        var entity = (City) entityFactory.getObject(City.class.getSimpleName());
        BeanUtils.copyProperties(request, entity);

        logger.info(MESSAGE_PATTERN, ENTITY, entity);
        entity = cityRepository.save(entity);
        return super.modelBuilder.createCityModel(entity);
    }
}
