package com.maxtattoo.command;

import com.maxtattoo.model.OrderModel;
import com.maxtattoo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class OrderCommand extends GenericCommand{

    @Autowired
    private OrderService orderService;

    public OrderModel findById(Long id){
        return orderService.findById(id);
    }

}
