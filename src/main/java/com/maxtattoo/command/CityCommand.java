package com.maxtattoo.command;

import com.maxtattoo.pojo.entity.City;
import com.maxtattoo.pojo.model.CityModel;
import com.maxtattoo.pojo.request.CityRequest;
import com.maxtattoo.service.CityService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class CityCommand extends GenericCommand {

    @Autowired
    private CityService cityService;

    public CityModel findById(Long id){
        logger.info("{} id: {}", REQUEST, id);
        return cityService.findById(id);
    }

    public CityModel saveCity(CityRequest request){
        logger.info("{}: {}", REQUEST, request);
        var entity = new City();
        BeanUtils.copyProperties(request, entity);
        return cityService.saveCity(entity);
    }
}
