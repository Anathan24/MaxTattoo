package com.maxtattoo.builder;

import com.maxtattoo.builder.interfaces.GenerciBuilder;
import com.maxtattoo.database.entity.*;
import com.maxtattoo.model.*;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ModelBuilder implements GenerciBuilder {

    public List<ClientModel> createClientModel(List<Client> clients){
        return clients.stream().map(client -> {
            var clientModel = new ClientModel();
            clientModel.setId(client.getClientId());
            clientModel.setName(client.getName());
            clientModel.setSurname(client.getSurname());
            clientModel.setGender(client.getGender());
            clientModel.setDescription(client.getDescription());
            clientModel.setOrders(client.getOrders().stream().map(this::createOrderModel).collect(Collectors.toCollection(LinkedList::new)));
            return clientModel;
        }).collect(Collectors.toCollection(LinkedList::new));
    }

    public OrderModel createOrderModel(Order order){
        var orderModel = new OrderModel();
        orderModel.setId(order.getOrderId());
        orderModel.setSittingNumber(order.getSittingNumber());
        orderModel.setOrderPrice(order.getOrderPrice());
        orderModel.setPrepayment(order.getPrepayment());
        orderModel.setStartDate(order.getStartDate());
        orderModel.setEndDate(order.getEndDate());
        orderModel.setOrderType(createOrderTypeModel(order.getOrderType()));
        orderModel.setState(createStateModel(order.getOrderState()));
        orderModel.setSittings(order.getSittings().stream().map(this::createSittingModel).collect(Collectors.toCollection(LinkedList::new)));
        return orderModel;
    }

    public SittingModel createSittingModel(Sitting sitting){
        var sittingModel = new SittingModel();
        sittingModel.setId(sitting.getSittingId());
        sittingModel.setDate(sitting.getSittingDate());
        sittingModel.setHours(sitting.getSpentHours());
        sittingModel.setPrice(sitting.getSittingPrice());
        sittingModel.setNote(sitting.getSittingNote());
        sittingModel.setOrderId(sitting.getOrderId());
        sittingModel.setState(createStateModel(sitting.getSittingState()));
        sittingModel.setPaints(sitting.getPaints().stream().map(this::createPaintModel).collect(Collectors.toCollection(LinkedList::new)));
        sittingModel.setNeedles(sitting.getNeedles().stream().map(this::createNeedleModel).collect(Collectors.toCollection(LinkedList::new)));
        return sittingModel;
    }

    public OrderTypeModel createOrderTypeModel(OrderType orderType){
        return new OrderTypeModel(orderType.getOrderTypeId(), orderType.getType());
    }

    public StateModel createStateModel(State state){
        return new StateModel(state.getStateId(), state.getStateName());
    }

    public PaintModel createPaintModel(Paint paint){
        return new PaintModel(paint.getPaintId(), paint.getPaintProducer(), paint.getColor());
    }

    public NeedleModel createNeedleModel(Needle needle){
        return new NeedleModel(needle.getNeedleId(),needle.getNeedleProducer(), needle.getNeedleCode(), needle.getNeedleSharpening());
    }
}
