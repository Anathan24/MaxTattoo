package com.maxtattoo.command;

import com.maxtattoo.model.OrderModel;
import com.maxtattoo.service.OrderService;
import com.maxtattoo.service.OrderTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("prototype")
public class OrderCommand extends GenericCommand{

    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderTypeService orderTypeService;

    public OrderModel findOrderById(Long id){
        return orderService.findOrderById(id);
    }

/*    public List<OrderModel> findAllOrdersByType(String type){
        var orderType = orderTypeService.findOrderTypeByType(type);
        return orderService.finaAllOrdersByType(orderType.getId());
    }*/
}
