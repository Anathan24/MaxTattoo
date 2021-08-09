package com.maxtattoo.builder;

import com.maxtattoo.pojo.entity.*;
import com.maxtattoo.pojo.model.*;
import org.springframework.beans.BeanUtils;
import com.maxtattoo.utils.StateEnum;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.stream.Collectors;

@Service
public class ModelBuilder extends GenericBuilder {

    public ClientModel createClientModel(Client client){
        var model = new ClientModel();
        BeanUtils.copyProperties(client, model);
        model.setLocation(createLocationModel(client.getLocation()));
        model.setOrders(client.getOrders().stream().map(this::createOrderModel).collect(Collectors.toCollection(LinkedList::new)));
        return model;
    }

    public OrderModel createOrderModel(Order order) {
        var model = new OrderModel();
        BeanUtils.copyProperties(order, model);
        model.setOrderType(createOrderTypeModel(order.getOrderType()));
        model.setState(StateEnum.findByValue(order.getOrderState().getValue()));
        model.setSittings(order.getSittings().stream().map(this::createSittingModel).collect(Collectors.toCollection(LinkedList::new)));
        return model;
    }

    public SittingModel createSittingModel(Sitting sitting) {
        var model = new SittingModel();
        BeanUtils.copyProperties(sitting, model);
        model.setState(StateEnum.findByValue(sitting.getSittingState().getValue()));
        model.setPaints(sitting.getPaints().stream().map(this::createPaintModel).collect(Collectors.toCollection(LinkedList::new)));
        model.setNeedles(sitting.getNeedles().stream().map(this::createNeedleModel).collect(Collectors.toCollection(LinkedList::new)));
        return model;
    }

    public CityModel createCityModel(City city) {
        var model = new CityModel();
        BeanUtils.copyProperties(city, model);
        logger.info(MODEL_STRING, model);
        return model;
    }

    public LocationModel createLocationModel(Location location) {
        var model = new LocationModel();
        BeanUtils.copyProperties(location, model);
        model.setCites(location.getCities().stream().map(this::createCityModel).collect(Collectors.toCollection(LinkedList::new)));
        logger.info(MODEL_STRING, model);
        return model;
    }

    public OrderTypeModel createOrderTypeModel(OrderType orderType) {
        var model = new OrderTypeModel();
        BeanUtils.copyProperties(orderType, model);
        logger.info(MODEL_STRING, model);
        return model;
    }

    public PaintModel createPaintModel(Paint paint) {
        var model = new PaintModel();
        BeanUtils.copyProperties(paint, model);
        logger.info(MODEL_STRING, model);
        return model;
    }

    public NeedleModel createNeedleModel(Needle needle) {
        var model = new NeedleModel();
        BeanUtils.copyProperties(needle, model);
        logger.info(MODEL_STRING, model);
        return model;
    }
}
