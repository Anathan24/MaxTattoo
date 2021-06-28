package com.maxtattoo.transformer.entitymodel;

import com.maxtattoo.database.entity.*;
import com.maxtattoo.model.*;

public interface EntityModelTransformer {

    default PaintModel paintEntityModelTransformer(Paint paint){
        PaintModel paintModel = new PaintModel();
        paintModel.setId(paint.getPaintId());
        paintModel.setProducer(paint.getPaintProducer());
        paintModel.setColor(paint.getColor());
        return paintModel;
    }

    default NeedleModel needleEntityModelTransformer(Needle needle){
        NeedleModel needleModel = new NeedleModel();
        needleModel.setId(needle.getNeedleId());
        needleModel.setProducer(needle.getNeedleProducer());
        needleModel.setCode(needle.getNeedleCode());
        needleModel.setSharpening(needle.getNeedleSharpening());
        return needleModel;
    }

    default SittingModel sittingEntityModelTransformer(Sitting sitting){
        SittingModel sittingModel = new SittingModel();
        sittingModel.setId(sitting.getSittingId());
        sittingModel.setDate(sitting.getSittingDate());
        sittingModel.setHours(sitting.getSpentHours());
        sittingModel.setPrice(sitting.getSittingPrice());
        sittingModel.setNote(sitting.getSittingNote());
        return sittingModel;
    }

    default OrderModel orderEntityModelTransformer(Order order){
        OrderModel orderModel = new OrderModel();
        orderModel.setId(order.getOrderId());
        orderModel.setSittingNumber(order.getSittingNumber());
        orderModel.setOrderPrice(order.getOrderPrice());
        orderModel.setPrepayment(order.getPrepayment());
        orderModel.setStartDate(order.getStartDate());
        orderModel.setEndDate(order.getEndDate());

        //TODO aggiungere la gestione dello stato e tipo ordine
        return orderModel;
    }

    default ClientModel clientEntityModelTransformer(Client client){
        ClientModel clientModel = new ClientModel();
        clientModel.setId(client.getClientId());
        clientModel.setName(client.getName());
        clientModel.setSurname(client.getSurname());
        clientModel.setGender(client.getGender());
        clientModel.setDescription(client.getDescription());
        //TODO aggiungere la gestione della locazione relativa al cliente
        return clientModel;
    }
}
