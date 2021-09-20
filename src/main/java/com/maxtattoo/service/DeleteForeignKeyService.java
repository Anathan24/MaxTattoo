package com.maxtattoo.service;

import com.maxtattoo.database.repository.*;
import com.maxtattoo.service.enums.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteForeignKeyService extends GenericService {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private LocationCityRepository locationCityRepository;
    @Autowired
    private SittingPaintRepository sittingPaintRepository;
    @Autowired
    private SittingNeedleRepository sittingNeedleRepository;

    public void controller(Entity entityName, Long entityId) {
        switch (entityName){
            case CITY:
                deleteLocationCityRelationByCityId(entityId);
                break;
            case CLIENT:
                deleteOrdersClientFk(entityId);
                break;
            case IMAGE:
            case ORDER:
                //Per l'ordine e Image non ci sono chiavi esterne che bloccano la cancellazione del record
                break;
            case ORDER_TYPE:
                deleteOrdersOrderTypeFk(entityId);
                break;
            case LOCATION:
                deleteLocationCityRelationByLocationId(entityId);
                deleteClientsLocationFk(entityId);
                break;
            case SITTING:
                deleteSittingPaintRelationBySittingId(entityId);
                deleteSittingNeedleRelationBySittingId(entityId);
                break;
            case PAINT:
                deleteSittingPaintRelationByPaintId(entityId);
                break;
            case NEEDLE:
                deleteSittingNeedleRelationByNeedleId(entityId);
                break;

            default: throw new IllegalArgumentException("Does not found entity with name: "+entityName);
        }
    }

    private void deleteOrdersClientFk(Long clientId) {
        var orders = orderRepository.findAllByClientId(clientId);
        orders.forEach(order -> {
            order.setClientId(null);
            orderRepository.save(order);
        });
    }

    private void deleteOrdersOrderTypeFk(Long orderTypeId) {
        var orders = orderRepository.findAllByOrderTypeId(orderTypeId);
        orders.forEach(order -> {
            order.setOrderType(null);
            orderRepository.save(order);
        });
    }

    private void deleteLocationCityRelationByLocationId(Long locationId) {
        var relations = locationCityRepository.findAllByLocationId(locationId);
        locationCityRepository.deleteAll(relations);
    }

    private void deleteClientsLocationFk(Long locationId) {
        var clients = clientRepository.findAllByLocationId(locationId);
        clients.forEach(client -> {
            client.setLocation(null);
            clientRepository.save(client);
        });
    }

    private void deleteLocationCityRelationByCityId(Long cityId){
        var relations = locationCityRepository.findAllByCityId(cityId);
        locationCityRepository.deleteAll(relations);
    }

    private void deleteSittingPaintRelationBySittingId(Long sittingId) {
        var relations = sittingPaintRepository.findAllBySittingId(sittingId);
        sittingPaintRepository.deleteAll(relations);
    }

    private void deleteSittingNeedleRelationBySittingId(Long sittingId) {
        var relations = sittingNeedleRepository.findAllBySittingId(sittingId);
        sittingNeedleRepository.deleteAll(relations);
    }

    private void deleteSittingPaintRelationByPaintId(Long paintId){
        var relations = sittingPaintRepository.findAllByPaintId(paintId);
        sittingPaintRepository.deleteAll(relations);
    }

    private void deleteSittingNeedleRelationByNeedleId(Long needleId){
        var relations = sittingNeedleRepository.findAllByNeedleId(needleId);
        sittingNeedleRepository.deleteAll(relations);
    }

}
