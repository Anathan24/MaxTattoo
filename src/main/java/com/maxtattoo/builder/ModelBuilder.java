package com.maxtattoo.builder;

import com.maxtattoo.factory.AbstractFactory;
import com.maxtattoo.factory.FactoryProducer;
import com.maxtattoo.factory.ModelFactory;
import com.maxtattoo.dto.entity.*;
import com.maxtattoo.dto.model.*;
import com.maxtattoo.service.enums.Entity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ModelBuilder implements GenericBuilder {

    private final AbstractFactory modelFactory = FactoryProducer.getFactory(ModelFactory.class.getSimpleName());

    @Override
    public <INPUT, OUTPUT> List<OUTPUT> buildModel(List<INPUT> input, Class<OUTPUT> output) {
        List<OUTPUT> result = new LinkedList<>();
        input.forEach(entity -> result.add(buildModel(entity, output)));
        return result;
    }

    @Override
    public <INPUT, OUTPUT> OUTPUT buildModel(INPUT input, Class<OUTPUT> output) {
        Entity objectName = Entity.findByValue(input.getClass().getSimpleName());
        switch(objectName) {
            case CITY:
                City city = (City) input;
                return output.cast(createCityModel(city));
            case CLIENT:
                Client client = (Client) input;
                return  output.cast(createClientModel(client));
            case LOCATION:
                Location location = (Location) input;
                return output.cast(createLocationModel(location));
            case NEEDLE:
                Needle needle = (Needle) input;
                return output.cast(createNeedleModel(needle));
            case ORDER:
                Order order = (Order) input;
                return output.cast(createOrderModel(order));
            case ORDER_TYPE:
                OrderType orderType = (OrderType) input;
                return output.cast(createOrderTypeModel(orderType));
            case PAINT:
                Paint paint = (Paint) input;
                return output.cast(createPaintModel(paint));
            case SITTING:
                Sitting sitting = (Sitting) input;
                return output.cast(createSittingModel(sitting));

            default: throw new IllegalArgumentException("Does not found any model with name: "+objectName);
        }
    }

    private ClientModel createClientModel(Client client) {
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

    private OrderModel createOrderModel(Order order) {
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

    private SittingModel createSittingModel(Sitting sitting) {
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

    private CityModel createCityModel(City city) {
        if(city == null)
            return null;

        var model = (CityModel) modelFactory.getObject(CityModel.class.getSimpleName());
        BeanUtils.copyProperties(city, model);
        return model;
    }

    private LocationModel createLocationModel(Location location) {
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

    private OrderTypeModel createOrderTypeModel(OrderType orderType) {
        if(orderType == null)
            return null;

        var model = (OrderTypeModel) modelFactory.getObject(OrderTypeModel.class.getSimpleName());
        BeanUtils.copyProperties(orderType, model);
        return model;
    }

    private PaintModel createPaintModel(Paint paint) {
        if(paint == null)
            return null;

        var model = (PaintModel) modelFactory.getObject(PaintModel.class.getSimpleName());
        BeanUtils.copyProperties(paint, model);
        return model;
    }

    private NeedleModel createNeedleModel(Needle needle) {
        if(needle == null)
            return null;

        var model = (NeedleModel) modelFactory.getObject(NeedleModel.class.getSimpleName());
        BeanUtils.copyProperties(needle, model);
        return model;
    }
}
