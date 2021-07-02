package com.maxtattoo.builder;

import com.maxtattoo.builder.interfaces.GenerciBuilder;
import com.maxtattoo.model.*;
import com.maxtattoo.response.*;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ResponseBuilder implements GenerciBuilder {

    public List<ClientResponse> createClientResponse(List<ClientModel> clients){
        return clients.stream().map(this::createClientResponse).collect(Collectors.toCollection(LinkedList::new));
    }

    public ClientResponse createClientResponse(ClientModel clientModel){
        var clientResponse = new ClientResponse();
        clientResponse.setId(clientModel.getId());
        clientResponse.setName(clientModel.getName());
        clientResponse.setSurname(clientModel.getSurname());
        clientResponse.setGender(clientModel.getGender());
        clientResponse.setDescription(clientModel.getDescription());
        clientResponse.setOrders(clientModel.getOrders().stream().map(this::createOrderResponse).collect(Collectors.toCollection(LinkedList::new)));
        return clientResponse;
    }

    public OrderResponse createOrderResponse(OrderModel order){
        var orderResponse = new OrderResponse();
        orderResponse.setId(order.getId());
        orderResponse.setSittingNumber(order.getSittingNumber());
        orderResponse.setOrderPrice(order.getOrderPrice());
        orderResponse.setPrepayment(order.getPrepayment());
        orderResponse.setStartDate(order.getStartDate());
        orderResponse.setEndDate(order.getEndDate());
        orderResponse.setOrderType(createOrderTypeModel(order.getOrderType()));
        orderResponse.setState(createStateResponse(order.getState()));
        orderResponse.setSittings(order.getSittings().stream().map(this::createSittingResponse).collect(Collectors.toCollection(LinkedList::new)));
        return orderResponse;
    }

    public SittingResponse createSittingResponse(SittingModel sitting){
        var sittingResponse = new SittingResponse();
        sittingResponse.setId(sitting.getId());
        sittingResponse.setDate(sitting.getDate());
        sittingResponse.setHours(sitting.getHours());
        sittingResponse.setPrice(sitting.getPrice());
        sittingResponse.setNote(sitting.getNote());
        sittingResponse.setOrderId(sitting.getOrderId());
        sittingResponse.setState(createStateResponse(sitting.getState()));
        sittingResponse.setPaints(sitting.getPaints().stream().map(this::createPaintResponse).collect(Collectors.toCollection(LinkedList::new)));
        sittingResponse.setNeedles(sitting.getNeedles().stream().map(this::createNeedleResponse).collect(Collectors.toCollection(LinkedList::new)));
        return sittingResponse;
    }

    public OrderTypeResponse createOrderTypeModel(OrderTypeModel orderType){
        return new OrderTypeResponse(orderType.getId(), orderType.getValue());
    }

    public StateResponse createStateResponse(StateModel state){
        return new StateResponse(state.getId(), state.getValue());
    }

    public PaintResponse createPaintResponse(PaintModel paint){
        return new PaintResponse(paint.getId(), paint.getProducer(), paint.getColor());
    }

    public NeedleResponse createNeedleResponse(NeedleModel needle){
        return new NeedleResponse(needle.getId(),needle.getProducer(), needle.getCode(), needle.getSharpening());
    }
}
