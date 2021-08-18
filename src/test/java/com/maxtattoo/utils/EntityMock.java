package com.maxtattoo.utils;

import com.maxtattoo.bean.entity.*;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
public class EntityMock {

    public Client createClientEntity(Long clientId){
        Client client = new Client();
        client.setId(clientId);
        client.setName("Client Name");
        client.setSurname("Client Surname");
        client.setGender("Male/Female");
        client.setDescription("Client Description");
        return client;
    }

    public Order createOrderEntity(Long orderId){
        Order order = new Order();
        order.setId(orderId);
        order.setOrderPrice(100);
        order.setStartDate(new Date(System.currentTimeMillis()));
        order.setEndDate(new Date(System.currentTimeMillis()));
        order.setSittingNumber(17);
        order.setPrepayment(200);
        order.setOrderState("Finished");
        order.setOrderType(createOrderTypeEntity(1L, "Tattoo"));
        return order;
    }

    public Sitting createSittingEntity(Long sittingId, Long orderId){
        Sitting sitting = new Sitting();
        sitting.setId(sittingId);
        sitting.setOrderId(orderId);
        //sitting.setDate(new Timestamp(System.currentTimeMillis()));
        sitting.setPaid(0);
        sitting.setNotes("Sitting Note");
        sitting.setSpentHours(4d);
        sitting.setSittingState("TODO");
        return sitting;
    }

    public OrderType createOrderTypeEntity(Long orderTypeId, String type){
        OrderType orderType = new OrderType();
        orderType.setId(orderTypeId);
        orderType.setValue(type);
        return orderType;
    }

    public Paint createPaintEntity(Long paintId){
        Paint paint = new Paint();
        paint.setId(paintId);
        paint.setProducer("Paint producer");
        paint.setColor("Blue");
        return paint;
    }

    public Needle createNeedleEntity(Long needleId){
        Needle needle = new Needle();
        needle.setId(needleId);
        needle.setCode("12c");
        needle.setProducer("Needle producer");
        needle.setSharpening("Needle Sharpening");
        return needle;
    }
}
