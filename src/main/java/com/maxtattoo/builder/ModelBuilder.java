package com.maxtattoo.builder;

import com.maxtattoo.factory.AbstractFactory;
import com.maxtattoo.factory.FactoryProducer;
import com.maxtattoo.factory.ModelFactory;
import com.maxtattoo.dto.entity.*;
import com.maxtattoo.dto.model.*;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ModelBuilder implements GenericBuilder {

    private final AbstractFactory modelFactory = FactoryProducer.getFactory(ModelFactory.class.getSimpleName());

    @Override
    public <INPUT, OUTPUT> List<OUTPUT> buildListModel(List<INPUT> input, Class<OUTPUT> output) {
        List<OUTPUT> result = new LinkedList<>();
        input.forEach(entity -> result.add(buildModel(entity, output)));
        return result;
    }

    @Override
    public <INPUT, OUTPUT> OUTPUT buildModel(INPUT input, Class<OUTPUT> output) {
        String objectName = input.getClass().getSimpleName();
        switch(objectName) {
            case "City":
                City city = (City) input;
                return output.cast(createCityModel(city));
            case "Client":
                Client client = (Client) input;
                return  output.cast(createClientModel(client));
            case "Location":
                Location location = (Location) input;
                return output.cast(createLocationModel(location));
            case "Needle":
                Needle needle = (Needle) input;
                return output.cast(createNeedleModel(needle));
            case "Order":
                Order order = (Order) input;
                return output.cast(createOrderModel(order));
            case "OrderType":
                OrderType orderType = (OrderType) input;
                return output.cast(createOrderTypeModel(orderType));
            case "Paint":
                Paint paint = (Paint) input;
                return output.cast(createPaintModel(paint));
            case "Sitting":
                Sitting sitting = (Sitting) input;
                return output.cast(createSittingModel(sitting));

            default: throw new IllegalArgumentException("Does not found model with name: "+objectName);
        }
    }

    public ClientModel createClientModel(Client client) {
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
