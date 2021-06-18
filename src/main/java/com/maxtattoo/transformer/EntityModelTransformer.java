package com.maxtattoo.transformer;

import com.maxtattoo.database.entity.*;
import com.maxtattoo.model.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EntityModelTransformer implements GenericTransformer {

    public ClientModel clientEntityIntoModelTransformer(Client client){
        var clientModel = new ClientModel();
        clientModel.setClientId(client.getClientId());
        clientModel.setName(client.getName());
        clientModel.setSurname(client.getSurname());
        clientModel.setGender(client.getGender());
        clientModel.setDescription(client.getDescription());
        return clientModel;
    }

    public List<OrderModel> orderEntityIntoModelTransformer(List<Order> orders){
        List<OrderModel> ordersModel = new ArrayList<>();
        for(Order order: orders){
            var orderModel = new OrderModel();
            orderModel.setOrderId(order.getOrderId());
            orderModel.setSittingNumber(order.getSittingNumber());
            orderModel.setOrderPrice(order.getOrderPrice());
            orderModel.setPrepayment(order.getPrepayment());
            orderModel.setStartDate(order.getStartDate());
            orderModel.setEndDate(order.getEndDate());
            //TODO da gestire lo stato e il tipo dìordine
            ordersModel.add(orderModel);
        }
        return ordersModel;
    }

    public List<SittingModel> sittingEntityIntoModelTransformer(List<Sitting> sittings){
        List<SittingModel> sittingsModel = new ArrayList<>();
        return sittingsModel;
    }

    public List<PaintModel> paintEntityIntoModelTransformer(List<Paint> paints){
        List<PaintModel> paintsModel = new ArrayList<>();
        return paintsModel;
    }

    public List<NeedleModel> needleEntityIntoModelTransformer(List<Needle> needles){
        List<NeedleModel> needlesModel = new ArrayList<>();
        return needlesModel;
    }
}
