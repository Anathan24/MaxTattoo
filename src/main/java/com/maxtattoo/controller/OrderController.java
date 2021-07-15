package com.maxtattoo.controller;

import com.maxtattoo.command.OrderCommand;
import com.maxtattoo.model.OrderModel;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping(value = "/order", produces = {MediaType.APPLICATION_JSON_VALUE, "application/hal+json"})
public class OrderController extends GenericController {

    @Autowired
    private BeanFactory beanFactory;

    @GetMapping(value = "/findOrderById")
    public ResponseEntity<OrderModel> findOrderById(@RequestParam Long id){
        var orderCommand = beanFactory.getBean(OrderCommand.class);
        var order = orderCommand.findOrderById(id);
        return ok(order);
    }

}
