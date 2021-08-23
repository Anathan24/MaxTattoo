package com.maxtattoo.builder;

import com.maxtattoo.factory.AbstractFactory;
import com.maxtattoo.factory.FactoryProducer;
import com.maxtattoo.factory.ModelFactory;
import com.maxtattoo.dto.entity.*;
import com.maxtattoo.dto.model.*;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.stream.Collectors;

@Service
public class ModelBuilder extends GenericBuilder {

    private final AbstractFactory modelFactory = FactoryProducer.getFactory(ModelFactory.class.getSimpleName());

    public ClientModel createClientModel(Client client){
        if(client == null)
            return null;

        var model = (ClientModel) modelFactory.getObject(ClientModel.class.getSimpleName());
        BeanUtils.copyProperties(client, model);

        model.setLocation(createLocationModel(client.getLocation()));
        model.setOrders(client.getOrders()
                .stream()
                .map(this::createOrderModel)
                .collect(Collectors.toCollection(LinkedList::new)));

        return model;
    }

    public OrderModel createOrderModel(Order order) {
        if(order == null)
            return null;

        var model = (OrderModel) modelFactory.getObject(OrderModel.class.getSimpleName());
        BeanUtils.copyProperties(order, model);

        model.setStartDate(order.getStartDate().toLocalDate());
        model.setEndDate(order.getEndDate().toLocalDate());
        model.setOrderType(createOrderTypeModel(order.getOrderType()));
        model.setSittings(order.getSittings()
                .stream()
                .map(this::createSittingModel)
                .collect(Collectors.toCollection(LinkedList::new)));

        return model;
    }

    public SittingModel createSittingModel(Sitting sitting) {
        if(sitting == null)
            return null;

        var model = (SittingModel) modelFactory.getObject(SittingModel.class.getSimpleName());
        BeanUtils.copyProperties(sitting, model);

        model.setDate(sitting.getDateTime().toLocalDateTime());
        model.setPaints(sitting.getPaints()
                .stream()
                .map(this::createPaintModel)
                .collect(Collectors.toCollection(LinkedList::new)));
        model.setNeedles(sitting.getNeedles()
                .stream()
                .map(this::createNeedleModel)
                .collect(Collectors.toCollection(LinkedList::new)));

        return model;
    }

    public CityModel createCityModel(City city) {
        if(city == null)
            return null;

        var model = (CityModel) modelFactory.getObject(CityModel.class.getSimpleName());
        BeanUtils.copyProperties(city, model);
        return model;
    }

    public LocationModel createLocationModel(Location location) {
        if (location == null)
            return null;

        var model = (LocationModel) modelFactory.getObject(LocationModel.class.getSimpleName());
        BeanUtils.copyProperties(location, model);

        model.setCites(location.getCities()
                .stream()
                .map(this::createCityModel)
                .collect(Collectors.toCollection(LinkedList::new)));

        return model;
    }

    public OrderTypeModel createOrderTypeModel(OrderType orderType) {
        if(orderType == null)
            return null;

        var model = (OrderTypeModel) modelFactory.getObject(OrderTypeModel.class.getSimpleName());
        BeanUtils.copyProperties(orderType, model);
        return model;
    }

    public PaintModel createPaintModel(Paint paint) {
        if(paint == null)
            return null;

        var model = (PaintModel) modelFactory.getObject(PaintModel.class.getSimpleName());
        BeanUtils.copyProperties(paint, model);
        return model;
    }

    public NeedleModel createNeedleModel(Needle needle) {
        if(needle == null)
            return null;

        var model = (NeedleModel) modelFactory.getObject(NeedleModel.class.getSimpleName());
        BeanUtils.copyProperties(needle, model);
        return model;
    }
}
