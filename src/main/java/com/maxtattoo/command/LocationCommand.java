package com.maxtattoo.command;

import com.maxtattoo.pojo.entity.Location;
import com.maxtattoo.pojo.model.LocationModel;
import com.maxtattoo.pojo.request.LocationRequest;
import com.maxtattoo.service.LocationService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class LocationCommand extends GenericCommand {

    @Autowired
    private LocationService locationService;

    public LocationModel findById(Long id){
        logger.info("{}: {}",REQUEST, id);
        return locationService.findById(id);
    }

    public LocationModel saveLocation(LocationRequest request){
        logger.info("{}: {}", REQUEST, request);
        var entity = new Location();
        BeanUtils.copyProperties(request, entity);
        return locationService.saveLocation(entity);
    }
}
