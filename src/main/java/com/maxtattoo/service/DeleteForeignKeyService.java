package com.maxtattoo.service;

import com.maxtattoo.database.repository.*;
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

    public void controller(String entityName, Long entityId) {
        switch (entityName){
            case "City":
                deleteLocationCityRelationByCityId(entityId);
                break;
            case "Client":
                deleteOrdersClientFk(entityId);
                break;
            case "OrderType":
                deleteOrdersOrderTypeFk(entityId);
                break;
            case "Location":
                deleteLocationCityRelationByLocationId(entityId);
                deleteClientsLocationFk(entityId);
                break;
            case "Sitting":
                deleteSittingPaintRelationBySittingId(entityId);
                deleteSittingNeedleRelationBySittingId(entityId);
                break;
            case "Paint":
                deleteSittingPaintRelationByPaintId(entityId);
                break;
            case "Needle":
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
