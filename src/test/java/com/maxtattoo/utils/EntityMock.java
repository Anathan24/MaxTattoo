package com.maxtattoo.utils;

import com.maxtattoo.database.entity.*;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Timestamp;

@Service
public class EntityMock {

    public Client createClientEntity(Long clientId){
        Client client = new Client();
        client.setClientId(clientId);
        client.setName("Client Name");
        client.setSurname("Client Surname");
        client.setGender("Male/Female");
        client.setDescription("Client Description");
        return client;
    }

    public Order createOrderEntity(Long orderId){
        Order order = new Order();
        order.setOrderId(orderId);
        order.setOrderPrice(100);
        order.setStartDate(new Date(System.currentTimeMillis()));
        order.setEndDate(new Date(System.currentTimeMillis()));
        order.setSittingNumber(17);
        order.setPrepayment(200);
        order.setOrderState(createStateEntity(1L, "Finished"));
        order.setOrderType(createOrderTypeEntity(1L, "Tattoo"));
        return order;
    }

    public Sitting createSittingEntity(Long sittingId, Long orderId){
        Sitting sitting = new Sitting();
        sitting.setSittingId(sittingId);
        sitting.setOrderId(orderId);
        sitting.setSittingDate(new Timestamp(System.currentTimeMillis()));
        sitting.setPaid(0);
        sitting.setSittingNote("Sitting Note");
        sitting.setSittingPrice(75);
        sitting.setSpentHours(4);
        sitting.setSittingState(createStateEntity(1L, "TODO"));
        return sitting;
    }

    public State createStateEntity(Long stateId, String stateName){
        State state = new State();
        state.setStateId(stateId);
        state.setStateName(stateName);
        return state;
    }

    public OrderType createOrderTypeEntity(Long orderTypeId, String type){
        OrderType orderType = new OrderType();
        orderType.setOrderTypeId(orderTypeId);
        orderType.setType(type);
        return orderType;
    }

    public Paint createPaintEntity(Long paintId){
        Paint paint = new Paint();
        paint.setPaintId(paintId);
        paint.setPaintProducer("Paint producer");
        paint.setColor("Blue");
        return paint;
    }

    public Needle createNeedleEntity(Long needleId){
        Needle needle = new Needle();
        needle.setNeedleId(needleId);
        needle.setNeedleCode("12c");
        needle.setNeedleProducer("Needle producer");
        needle.setNeedleSharpening("Needle Sharpening");
        return needle;
    }
}
