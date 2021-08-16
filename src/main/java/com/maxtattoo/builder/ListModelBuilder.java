package com.maxtattoo.builder;

import com.maxtattoo.bean.entity.*;
import com.maxtattoo.bean.model.*;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListModelBuilder extends ModelBuilder {

    public List<ClientModel> createListClientModel(List<Client> clients) {
        return clients.stream().map(super::createClientModel).collect(Collectors.toCollection(LinkedList::new));
    }

    public List<CityModel> createListCityModel(List<City> cities){
        return cities.stream().map(super::createCityModel).collect(Collectors.toCollection(LinkedList::new));
    }

    public List<LocationModel> createListLocationModel(List<Location> locations){
        return locations.stream().map(super::createLocationModel).collect(Collectors.toCollection(LinkedList::new));
    }

    public List<OrderModel> createListOrderModel(List<Order> orders) {
        return orders.stream().map(super::createOrderModel).collect(Collectors.toCollection(LinkedList::new));
    }

    public List<OrderTypeModel> createListOrderTypeModel(List<OrderType> orderTypes) {
        return orderTypes.stream().map(super::createOrderTypeModel).collect(Collectors.toCollection(LinkedList::new));
    }

    public List<PaintModel> createListPaintModel(List<Paint> paints){
        return paints.stream().map(super::createPaintModel).collect(Collectors.toCollection(LinkedList::new));
    }

    public List<NeedleModel> createListNeedleModel(List<Needle> needles){
        return needles.stream().map(super::createNeedleModel).collect(Collectors.toCollection(LinkedList::new));
    }
}
