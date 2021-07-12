package com.maxtattoo.service;

import com.maxtattoo.database.repository.LocationRepository;
import com.maxtattoo.model.LocationModel;
import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class LocationService extends GenericService{

    @Autowired
    private LocationRepository locationRepository;

    public LocationModel findLocationById(Long id){
        var location = locationRepository.findLocationById(id);
        return super.modelBuilder.createLocationModel(location);
    }
}
