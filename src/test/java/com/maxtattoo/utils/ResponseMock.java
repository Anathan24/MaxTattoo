package com.maxtattoo.utils;

import com.maxtattoo.dto.model.*;
import org.springframework.stereotype.Service;

@Service
public class ResponseMock {

    public ClientModel createClientModel(Long clientId){
        ClientModel client = new ClientModel();
        client.setClientId(clientId);
        client.setName("Client Name");
        client.setSurname("Client Surname");
        client.setGender("Male/Female");
        client.setDescription("Client Description");
        return client;
    }

    public OrderModel createOrderModel(Long orderId){
        OrderModel order = new OrderModel();
        order.setOrderId(orderId);
        order.setOrderPrice(100);

        order.setSittingNumber(17);
        order.setPrepayment(200);
        order.setOrderState("Finished");
        order.setOrderType(createOrderTypeModel(1L, "Tattoo"));
        return order;
    }

    public SittingModel createSittingModel(Long sittingId, Long orderId){
        SittingModel sitting = new SittingModel();
        sitting.setSittingId(sittingId);
        sitting.setOrderId(orderId);
        //sitting.setDate(new Timestamp(System.currentTimeMillis()));
        sitting.setPaid(0);
        sitting.setNotes("Sitting Note");
        sitting.setSpentHours(4d);
        sitting.setSittingState("To do");
        return sitting;
    }

    public OrderTypeModel createOrderTypeModel(Long orderTypeId, String type){
        OrderTypeModel orderType = new OrderTypeModel();
        orderType.setOrderTypeId(orderTypeId);
        orderType.setValue(type);
        return orderType;
    }

    public PaintModel createPaintModel(Long paintId){
        PaintModel paint = new PaintModel();
        paint.setPaintId(paintId);
        paint.setProducer("Paint producer");
        paint.setColor("Blue");
        return paint;
    }

    public NeedleModel createNeedleModel(Long needleId){
        NeedleModel needle = new NeedleModel();
        needle.setNeedleId(needleId);
        needle.setCode("12c");
        needle.setProducer("Needle producer");
        needle.setSharpening("Needle Sharpening");
        return needle;
    }
}
