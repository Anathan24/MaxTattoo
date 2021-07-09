package com.maxtattoo.controller;

import com.maxtattoo.command.OrderCommand;
import com.maxtattoo.model.OrderModel;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping(value = "/order", produces = {MediaType.APPLICATION_JSON_VALUE, "application/hal+json"})
public class OrderController extends GenericController{

    @Autowired
    private BeanFactory beanFactory;

    @GetMapping(value = "/id/{id}")
    public ResponseEntity<OrderModel> findOrderById(@PathVariable Long id){
        var orderCommand = beanFactory.getBean(OrderCommand.class);
        var order = orderCommand.findOrderById(id);
        return ok(order);
    }

/*    @GetMapping(value = "/orderType/{type}")
    public ResponseEntity<List<OrderModel>> findAllOrdersByType(String type){
        var orderCommand = beanFactory.getBean(OrderCommand.class);
        var orders = orderCommand.findAllOrdersByType(type);
        return ok(orders);
    }*/
}
