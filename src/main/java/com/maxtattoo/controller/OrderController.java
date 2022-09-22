package com.maxtattoo.controller;

import com.maxtattoo.command.*;
import com.maxtattoo.database.repository.OrderRepository;
import com.maxtattoo.database.repository.OrderTypeRepository;
import com.maxtattoo.dto.entity.OrderType;
import com.maxtattoo.dto.model.OrderModel;
import com.maxtattoo.dto.model.OrderTypeModel;
import com.maxtattoo.dto.request.OrderRequest;
import com.maxtattoo.dto.request.OrderTypeRequest;
import com.maxtattoo.service.enums.OrderState;
import com.maxtattoo.utils.GenericResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.maxtattoo.service.enums.Entity.ORDER;
import static com.maxtattoo.service.enums.Entity.ORDER_TYPE;
import static com.maxtattoo.utils.StringUtils.*;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping(value = "/order")
public class OrderController extends GenericController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderTypeRepository orderTypeRepository;

    @GetMapping(value = "/findById", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OrderModel> findById(@RequestParam Long id) {
        logger.info(START);
        var command = beanFactory.getBean(FindByIdCmd.class);
        var model = command.execute(orderRepository, OrderModel.class, id);
        logger.info(MESSAGE_PATTERN, MODEL, model);
        logger.info(END);
        return ok(model);
    }

    @GetMapping(value = "/findAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<OrderModel>> findAll() {
        logger.info(START);
        var command = super.beanFactory.getBean(FindAllCmd.class);
        var model = command.execute(orderRepository, OrderModel.class);
        logger.info(END);
        return ok(model);
    }

    @GetMapping(value = "/findOrderTypeById", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OrderTypeModel> findOrderTypeById(@RequestParam Long id) {
        logger.info(START);
        var command = super.beanFactory.getBean(FindByIdCmd.class);
        logger.info(MESSAGE_PATTERN, REQUEST, id);
        var model = command.execute(orderTypeRepository, OrderTypeModel.class, id);
        logger.info(MESSAGE_PATTERN, MODEL, model);
        logger.info(END);
        return ok(model);
    }

    @GetMapping(value = "/findAllOrderTypes", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<OrderTypeModel>> findAllOrderTypes() {
        logger.info(START);
        var command = super.beanFactory.getBean(FindAllCmd.class);
        var model = command.execute(orderTypeRepository, OrderTypeModel.class);
        logger.info(MESSAGE_PATTERN, MODEL, model);
        logger.info(END);
        return ok(model);
    }

    @GetMapping(value = "/findAllOrderStates", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<String>> findAllOrderStates() {
        logger.info(START);
        var result = Arrays.stream(OrderState.values()).map(OrderState::getValue).collect(Collectors.toCollection(ArrayList::new));
        logger.info("RESULT: {}", result);
        logger.info(END);
        return ok(result);
    }

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OrderModel> save(@RequestBody OrderRequest request) {
        logger.info(START);
        var command = beanFactory.getBean(SaveOrderCmd.class);
        logger.info("{}: {}", REQUEST, request);
        var model = command.execute(OrderModel.class, request);
        logger.info(MESSAGE_PATTERN, MODEL, model);
        logger.info(END);
        return ok(model);
    }

    @PostMapping(value = "/saveOrderType", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OrderTypeModel> saveOrderType(@RequestBody OrderTypeRequest request) {
        logger.info(START);
        var command = super.beanFactory.getBean(SaveCmd.class);
        logger.info("{}: {}", REQUEST, request);
        var model = command.execute(orderTypeRepository, OrderType.class, OrderTypeModel.class, request);
        logger.info(MESSAGE_PATTERN, MODEL, model);
        logger.info(END);
        return ok(model);
    }

    @DeleteMapping(value = "/deleteById")
    public ResponseEntity<GenericResponse> deleteById(@RequestParam("orderId") Long id) {
        logger.info(START);
        var command = super.beanFactory.getBean(DeleteByIdCmd.class);
        logger.info(MESSAGE_PATTERN, REQUEST, id);
        var result = command.execute(orderRepository, ORDER, id);
        logger.info("RESULT: {}", result);
        logger.info(END);
        return ok(result);
    }

    @DeleteMapping(value = "/deleteOrderTypeById")
    public ResponseEntity<GenericResponse> deleteOrderTypeById(@RequestParam("orderTypeId") Long id) {
        logger.info(START);
        var command = super.beanFactory.getBean(DeleteByIdCmd.class);
        logger.info(MESSAGE_PATTERN, REQUEST, id);
        var result = command.execute(orderTypeRepository, ORDER_TYPE, id);
        logger.info("RESULT: {}", result);
        logger.info(END);
        return ok(result);
    }
}
