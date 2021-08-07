package com.maxtattoo.command;

import com.maxtattoo.pojo.entity.OrderType;
import com.maxtattoo.pojo.model.OrderTypeModel;
import com.maxtattoo.pojo.request.OrderTypeRequest;
import com.maxtattoo.service.OrderTypeService;
import org.springframework.beans.BeanUtils;
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

    public OrderTypeModel saveOrderType(OrderTypeRequest request){
        var entity = new OrderType();
        BeanUtils.copyProperties(request, entity);
        logger.info("ENTITY: {}", entity);
        return orderTypeService.saveOrderType(entity);
    }
}
