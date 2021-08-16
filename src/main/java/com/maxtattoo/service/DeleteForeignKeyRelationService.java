package com.maxtattoo.service;

import com.maxtattoo.database.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteForeignKeyRelationService extends GenericService {

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

    public void deleteClientOrderRelationByClientId(Long clientId){
        var orders = orderRepository.findAllByClientId(clientId);
        orders.forEach(order -> {
            order.setClientId(null);
            orderRepository.save(order);
        });
    }

    public void deleteOrderOrderTypeRelationByOrderTypeId(Long orderTypeId) {
        var orders = orderRepository.findAllByOrderTypeId(orderTypeId);
        orders.forEach(order -> {
            order.setOrderType(null);
            orderRepository.save(order);
        });
    }

    public void deleteClientLocationRelationByLocationId(Long locationId) {
        var clients = clientRepository.findAllByLocationId(locationId);
        clients.forEach(client -> {
            client.setLocation(null);
            clientRepository.save(client);
        });
    }

    public void deleteSittingPaintRelationBySittingId(Long sittingId) {
        var relations = sittingPaintRepository.findAllBySittingId(sittingId);
        sittingPaintRepository.deleteAll(relations);
    }

    public void deleteSittingPaintRelationByPaintId(Long paintId){
        var relations = sittingPaintRepository.findAllByPaintId(paintId);
        sittingPaintRepository.deleteAll(relations);
    }

    public void deleteSittingNeedleRelationBySittingId(Long sittingId) {
        var relations = sittingNeedleRepository.findAllBySittingId(sittingId);
        sittingNeedleRepository.deleteAll(relations);
    }

    public void deleteSittingNeedleRelationByNeedleId(Long needleId){
        var relations = sittingNeedleRepository.findAllByNeedleId(needleId);
        sittingNeedleRepository.deleteAll(relations);
    }

    public void deleteLocationCityRelationByLocationId(Long locationId) {
        var relations = locationCityRepository.findAllByLocationId(locationId);
        locationCityRepository.deleteAll(relations);
    }

    public void deleteLocationCityRelationByCityId(Long cityId){
        var relations = locationCityRepository.findAllByCityId(cityId);
        locationCityRepository.deleteAll(relations);
    }
}
