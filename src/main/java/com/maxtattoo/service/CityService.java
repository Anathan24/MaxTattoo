package com.maxtattoo.service;

import com.maxtattoo.database.repository.CityRepository;
import com.maxtattoo.model.CityModel;
import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class CityService extends GenericService{

    @Autowired
    private CityRepository cityRepository;

    public CityModel findCityById(Long id){
        var city = cityRepository.findCityById(id);
        return super.modelBuilder.createCityModel(city);
    }

}
