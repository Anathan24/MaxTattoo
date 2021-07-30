package com.maxtattoo.command;

import com.maxtattoo.model.OrderTypeModel;
import com.maxtattoo.service.OrderTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class OrderTypeCommand extends GenericCommand {

    @Autowired
    private OrderTypeService orderTypeService;

    public OrderTypeModel findById(Long id){
        return orderTypeService.findById(id);
    }
}
