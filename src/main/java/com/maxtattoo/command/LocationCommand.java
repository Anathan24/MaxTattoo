package com.maxtattoo.command;

import com.maxtattoo.model.LocationModel;
import com.maxtattoo.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class LocationCommand extends GenericCommand {

    @Autowired
    private LocationService locationService;

    public LocationModel findById(Long id){
        return locationService.findById(id);
    }
}
