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
        logger.info(START);
        var command = super.beanFactory.getBean(OrderTypeCommand.class);
        var model = command.findById(id);
        logger.info(END);
        return ok(model);
    }

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OrderTypeModel> saveOrderType(@RequestBody OrderTypeRequest request){
        logger.info(START);
        var command = super.beanFactory.getBean(OrderTypeCommand.class);
        var model = command.saveOrderType(request);
        logger.info(END);
        return ok(model);
    }
}
