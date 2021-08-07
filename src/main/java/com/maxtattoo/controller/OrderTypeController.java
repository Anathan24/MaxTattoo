package com.maxtattoo.controller;

import com.maxtattoo.command.OrderTypeCommand;
import com.maxtattoo.pojo.model.OrderTypeModel;
import com.maxtattoo.pojo.request.OrderTypeRequest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping(value = "/orderType")
public class OrderTypeController extends GenericController{

    @GetMapping(value = "/findById", produces = {MediaType.APPLICATION_JSON_VALUE, "application/hal+json"})
    private ResponseEntity<OrderTypeModel> findById(@RequestParam Long id){
        var orderTypeCommand = super.beanFactory.getBean(OrderTypeCommand.class);
        var orderTypeModel = orderTypeCommand.findById(id);
        return ok(orderTypeModel);
    }

    @PostMapping(value = "/createOrderType", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OrderTypeModel> createOrderType(@RequestBody OrderTypeRequest request){
        var orderTypeCommand = super.beanFactory.getBean(OrderTypeCommand.class);
        var orderTypeModel = orderTypeCommand.saveOrderType(request);
        return ok(orderTypeModel);
    }
}
