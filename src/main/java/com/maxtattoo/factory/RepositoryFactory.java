package com.maxtattoo.factory;

import com.maxtattoo.database.repository.*;
import com.maxtattoo.service.enums.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class RepositoryFactory {

    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private LocationRepository locationRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderTypeRepository orderTypeRepository;
    @Autowired
    private SittingRepository sittingRepository;
    @Autowired
    private PaintRepository paintRepository;
    @Autowired
    private NeedleRepository needleRepository;
    @Autowired
    private ImageRepository imageRepository;

    @SuppressWarnings("unchecked")
    public <ENTITY, ID> JpaRepository<ENTITY, ID> getRepository(Entity entityName) {
            switch (entityName){
                case CITY:
                    return (JpaRepository<ENTITY, ID>) cityRepository;
                case LOCATION:
                    return (JpaRepository<ENTITY, ID>) locationRepository;
                case CLIENT:
                    return (JpaRepository<ENTITY, ID>) clientRepository;
                case ORDER:
                    return (JpaRepository<ENTITY, ID>) orderRepository;
                case ORDER_TYPE:
                    return (JpaRepository<ENTITY, ID>) orderTypeRepository;
                case SITTING:
                    return (JpaRepository<ENTITY, ID>) sittingRepository;
                case PAINT:
                    return (JpaRepository<ENTITY, ID>) paintRepository;
                case NEEDLE:
                    return (JpaRepository<ENTITY, ID>) needleRepository;
                case IMAGE:
                    return (JpaRepository<ENTITY, ID>)imageRepository;

                default: throw new IllegalArgumentException("Not found entity with name: "+ entityName);
            }
    }
}
