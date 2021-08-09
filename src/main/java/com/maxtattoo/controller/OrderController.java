package com.maxtattoo.controller;

import com.maxtattoo.command.OrderCommand;
import com.maxtattoo.pojo.model.OrderModel;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping(value = "/order")
public class OrderController extends GenericController {

    @GetMapping(value = "/findById", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OrderModel> findById(@RequestParam Long id){
        logger.info(START);
        var command = beanFactory.getBean(OrderCommand.class);
        logger.info("{} id: {}", REQUEST, id);
        var model = command.findById(id);
        logger.info(END);
        return ok(model);
    }
}
