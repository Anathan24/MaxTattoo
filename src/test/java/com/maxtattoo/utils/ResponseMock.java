package com.maxtattoo.utils;

import com.maxtattoo.model.*;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Timestamp;

@Service
public class ResponseMock {

    public ClientModel createClientModel(Long clientId){
        ClientModel client = new ClientModel();
        client.setId(clientId);
        client.setName("Client Name");
        client.setSurname("Client Surname");
        client.setGender("Male/Female");
        client.setDescription("Client Description");
        return client;
    }

    public OrderModel createOrderModel(Long orderId){
        OrderModel order = new OrderModel();
        order.setId(orderId);
        order.setOrderPrice(100);
        order.setStartDate(new Date(System.currentTimeMillis()));
        order.setEndDate(new Date(System.currentTimeMillis()));
        order.setSittingNumber(17);
        order.setPrepayment(200);
        order.setState(StateEnum.findByValue("Finished"));
        order.setOrderType(createOrderTypeModel(1L, "Tattoo"));
        return order;
    }

    public SittingModel createSittingModel(Long sittingId, Long orderId){
        SittingModel sitting = new SittingModel();
        sitting.setId(sittingId);
        sitting.setOrderId(orderId);
        sitting.setDate(new Timestamp(System.currentTimeMillis()));
        sitting.setPaid(0);
        sitting.setNote("Sitting Note");
        sitting.setPrice(75);
        sitting.setHours(4);
        sitting.setState(StateEnum.findByValue("TODO"));
        return sitting;
    }

    public OrderTypeModel createOrderTypeModel(Long orderTypeId, String type){
        OrderTypeModel orderType = new OrderTypeModel();
        orderType.setId(orderTypeId);
        orderType.setValue(type);
        return orderType;
    }

    public PaintModel createPaintModel(Long paintId){
        PaintModel paint = new PaintModel();
        paint.setId(paintId);
        paint.setProducer("Paint producer");
        paint.setColor("Blue");
        return paint;
    }

    public NeedleModel createNeedleModel(Long needleId){
        NeedleModel needle = new NeedleModel();
        needle.setId(needleId);
        needle.setCode("12c");
        needle.setProducer("Needle producer");
        needle.setSharpening("Needle Sharpening");
        return needle;
    }
}
