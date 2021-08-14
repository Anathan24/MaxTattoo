package com.maxtattoo.controller;

import com.maxtattoo.command.OrderCommand;
import com.maxtattoo.pojo.model.OrderModel;
import com.maxtattoo.pojo.model.OrderTypeModel;
import com.maxtattoo.pojo.request.OrderRequest;
import com.maxtattoo.pojo.request.OrderTypeRequest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping(value = "/order")
public class OrderController extends GenericController {

    @GetMapping(value = "/findById", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OrderModel> findById(@RequestParam Long id) {
        logger.info(START);
        var command = beanFactory.getBean(OrderCommand.class);
        var model = command.findById(id);
        logger.info(MESSAGE_PATTERN, MODEL, model);
        logger.info(END);
        return ok(model);
    }

    @GetMapping(value = "/findAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<OrderModel>> findAll(){
        logger.info(START);
        var command = super.beanFactory.getBean(OrderCommand.class);
        var model = command.findAll();
        logger.info(END);
        return ok(model);
    }

    @GetMapping(value = "/findOrderTypeById", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OrderTypeModel> findOrderTypeById(@RequestParam Long id){
        logger.info(START);
        var command = super.beanFactory.getBean(OrderCommand.class);
        logger.info("{} id: {}", REQUEST, id);
        var model = command.findOrderTypeById(id);
        logger.info(MESSAGE_PATTERN, MODEL, model);
        logger.info(END);
        return ok(model);
    }

    @GetMapping(value = "/findAllOrderTypes", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<OrderTypeModel>> findAllOrderTypes(){
        logger.info(START);
        var command = super.beanFactory.getBean(OrderCommand.class);
        var model = command.findAllOrderTypes();
        logger.info(MESSAGE_PATTERN, MODEL, model);
        logger.info(END);
        return ok(model);
    }

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OrderModel> save(@RequestBody OrderRequest request) {
        logger.info(START);
        var command = beanFactory.getBean(OrderCommand.class);
        logger.info("{}: {}", REQUEST, request);
        var model = command.save(request);
        logger.info(MESSAGE_PATTERN, MODEL, model);
        logger.info(END);
        return ok(model);
    }

    @PostMapping(value = "/saveOrderType", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OrderTypeModel> saveOrderType(@RequestBody OrderTypeRequest request){
        logger.info(START);
        var command = super.beanFactory.getBean(OrderCommand.class);
        logger.info("{}: {}", REQUEST, request);
        var model = command.saveOrderType(request);
        logger.info(MESSAGE_PATTERN, MODEL, model);
        logger.info(END);
        return ok(model);
    }
}
