package com.maxtattoo.service;

import com.maxtattoo.database.repository.ClientRepository;
import com.maxtattoo.database.repository.LocationCityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteForeignKeyRelationService extends GenericService {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private LocationCityRepository locationCityRepository;

    public void deleteLocationCityRelationByLocationId(Long locationId){
        var relations = locationCityRepository.findAllByLocationId(locationId);
        locationCityRepository.deleteAll(relations);
    }

    public void deleteLocationCityRelationByCityId(Long cityId){
        var relations = locationCityRepository.findAllByCityId(cityId);
        locationCityRepository.deleteAll(relations);
    }

    public void deleteClientLocationRelationByLocationId(Long locationId) {
        var clients = clientRepository.findAllByLocationId(locationId);
        clients.forEach(client -> {
            client.setLocation(null);
            clientRepository.save(client);
        });
    }
}
