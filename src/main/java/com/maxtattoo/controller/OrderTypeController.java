package com.maxtattoo.controller;

import com.maxtattoo.command.OrderTypeCommand;
import com.maxtattoo.model.OrderTypeModel;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping(value = "/orderType", produces = {MediaType.APPLICATION_JSON_VALUE, "application/hal+json"})
public class OrderTypeController extends GenericController{

    @GetMapping(value = "/findById")
    private ResponseEntity<OrderTypeModel> findById(@RequestParam Long id){
        var orderTypeCommand = super.beanFactory.getBean(OrderTypeCommand.class);
        var orderTypeModel = orderTypeCommand.findById(id);
        return ok(orderTypeModel);
    }
}
