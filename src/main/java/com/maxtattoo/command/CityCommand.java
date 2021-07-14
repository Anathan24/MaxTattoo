package com.maxtattoo.command;

import com.maxtattoo.model.CityModel;
import com.maxtattoo.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class CityCommand extends GenericCommand {

    @Autowired
    private CityService cityService;

    public CityModel findCityById(Long id){
        return cityService.findCityById(id);
    }
}
