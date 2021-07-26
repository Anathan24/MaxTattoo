package com.maxtattoo.builder;

import com.maxtattoo.builder.interfaces.GenerciBuilder;
import com.maxtattoo.database.entity.*;
import com.maxtattoo.model.*;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ModelBuilder implements GenerciBuilder {

    public List<ClientModel> createClientModel(List<Client> clients){
        return clients.stream().map(this::createClientModel).collect(Collectors.toCollection(LinkedList::new));
    }

    public ClientModel createClientModel(Client client){
        var model = new ClientModel();
        BeanUtils.copyProperties(client, model);
        model.setLocation(createLocationModel(client.getLocation()));
        model.setOrders(client.getOrders().stream().map(this::createOrderModel).collect(Collectors.toCollection(LinkedList::new)));
        return model;
    }

    public List<OrderModel> createOrderModel(List<Order> orders){
        return orders.stream().map(this::createOrderModel).collect(Collectors.toCollection(LinkedList::new));
    }

    public OrderModel createOrderModel(Order order){
        var model = new OrderModel();
        BeanUtils.copyProperties(order, model);
        model.setOrderType(createOrderTypeModel(order.getOrderType()));
        model.setState(createStateModel(order.getOrderState()));
        model.setSittings(order.getSittings().stream().map(this::createSittingModel).collect(Collectors.toCollection(LinkedList::new)));
        return model;
    }

    public SittingModel createSittingModel(Sitting sitting){
        var model = new SittingModel();
        BeanUtils.copyProperties(sitting, model);
        model.setState(createStateModel(sitting.getSittingState()));
        model.setPaints(sitting.getPaints().stream().map(this::createPaintModel).collect(Collectors.toCollection(LinkedList::new)));
        model.setNeedles(sitting.getNeedles().stream().map(this::createNeedleModel).collect(Collectors.toCollection(LinkedList::new)));
        return model;
    }

    public CityModel createCityModel(City city){
        return new CityModel(city.getId(), city.getName());
    }

    public LocationModel createLocationModel(Location location){
        var model = new LocationModel();
        BeanUtils.copyProperties(location, model);
        model.setCites(location.getCities().stream().map(this::createCityModel).collect(Collectors.toCollection(LinkedList::new)));
        return model;
    }

    public OrderTypeModel createOrderTypeModel(OrderType orderType){
        var model = new OrderTypeModel();
        BeanUtils.copyProperties(orderType, model);
        return model;
    }

    public StateModel createStateModel(State state){
        var model = new StateModel();
        BeanUtils.copyProperties(state, model);
        return model;
    }

    public PaintModel createPaintModel(Paint paint){
        var model = new PaintModel();
        BeanUtils.copyProperties(paint, model);
        return model;
    }

    public NeedleModel createNeedleModel(Needle needle){
        var model = new NeedleModel();
        BeanUtils.copyProperties(needle, model);
        return model;
    }
}
