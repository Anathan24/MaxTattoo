package com.maxtattoo.builder;

import com.maxtattoo.pojo.entity.Client;
import com.maxtattoo.pojo.entity.Order;
import com.maxtattoo.pojo.entity.OrderType;
import com.maxtattoo.pojo.model.ClientModel;
import com.maxtattoo.pojo.model.OrderModel;
import com.maxtattoo.pojo.model.OrderTypeModel;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListModelBuilder extends ModelBuilder {

    public List<ClientModel> createClientModel(List<Client> clients) {
        return clients.stream().map(super::createClientModel).collect(Collectors.toCollection(LinkedList::new));
    }

    public List<OrderModel> createOrderModel(List<Order> orders) {
        return orders.stream().map(super::createOrderModel).collect(Collectors.toCollection(LinkedList::new));
    }

    public List<OrderTypeModel> createOrderTypeModel(List<OrderType> orderTypes) {
        return orderTypes.stream().map(super::createOrderTypeModel).collect(Collectors.toCollection(LinkedList::new));
    }
}
