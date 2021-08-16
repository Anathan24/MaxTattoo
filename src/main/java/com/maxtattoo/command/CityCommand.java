package com.maxtattoo.command;

import com.maxtattoo.database.repository.CityRepository;
import com.maxtattoo.exception.ResourceNotFoundException;
import com.maxtattoo.pojo.EntityFactory;
import com.maxtattoo.pojo.entity.City;
import com.maxtattoo.pojo.model.CityModel;
import com.maxtattoo.pojo.request.CityRequest;
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
public class CityCommand extends GenericCommand {

    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private DataValidatorService dataValidatorService;
    @Autowired
    private DeleteForeignKeyRelationService deleteForeignKeyRelationService;

    public CityModel findById(Long id){
        var entity = cityRepository.findById(id);
        logger.info(MESSAGE_PATTERN, ENTITY, entity);
        if(entity.isPresent()) {
            return super.modelBuilder.createCityModel(entity.get());
        } else {
            String message = super.buildEntityNotFoundErrorMessage(City.class.getSimpleName(), id);
            logger.warn(message);
            throw new ResourceNotFoundException(message, HttpStatus.NOT_FOUND);
        }
    }

    public List<CityModel> findAll(){
        var entity = cityRepository.findAll();
        logger.info(MESSAGE_PATTERN, ENTITY, entity);

        return super.listModelBuilder.createCityModel(entity);
    }

    public CityModel save(CityRequest request){
        var entity = (City) EntityFactory.getEntity(City.class.getSimpleName());
        BeanUtils.copyProperties(request, entity);

        logger.info(MESSAGE_PATTERN, ENTITY, entity);
        entity = cityRepository.save(entity);
        return super.modelBuilder.createCityModel(entity);
    }

    public String deleteById(Long id){
        var cityId = dataValidatorService.cityIdValidation(id);
        deleteForeignKeyRelationService.deleteLocationCityRelationByCityId(cityId);
        cityRepository.deleteById(cityId);
        return "OK";
    }
}
