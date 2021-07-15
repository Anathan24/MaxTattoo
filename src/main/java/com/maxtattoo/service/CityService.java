package com.maxtattoo.service;

import com.maxtattoo.database.repository.CityRepository;
import com.maxtattoo.model.CityModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService extends GenericService {

    @Autowired
    private CityRepository cityRepository;

    public CityModel findCityById(Long id){
        var city = cityRepository.findCityById(id);
        return super.modelBuilder.createCityModel(city);
    }

}
