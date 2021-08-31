package com.maxtattoo.command;

import com.maxtattoo.database.repository.OrderRepository;
import com.maxtattoo.database.repository.OrderTypeRepository;
import com.maxtattoo.dto.entity.Order;
import com.maxtattoo.dto.model.OrderModel;
import com.maxtattoo.dto.request.OrderRequest;
import com.maxtattoo.service.DeleteForeignKeyService;
import com.maxtattoo.service.IdValidatorService;
import com.maxtattoo.service.OrderDataService;
import com.maxtattoo.service.enums.OrderState;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.maxtattoo.utils.StringUtils.ENTITY;
import static com.maxtattoo.utils.StringUtils.MESSAGE_PATTERN;

@Component
@Scope("prototype")
public class OrderCommand extends GenericCommand {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderTypeRepository orderTypeRepository;

    @Autowired
    private OrderDataService orderDataService;
    @Autowired
    private IdValidatorService idValidatorService;
    @Autowired
    private DeleteForeignKeyService deleteForeignKeyService;

    public List<String> findAllOrderStates() {
        return Arrays.stream(OrderState.values())
                .map(OrderState::getValue)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public OrderModel save(OrderRequest request) {
        var entity = (Order) entityFactory.getObject(Order.class.getSimpleName());
        BeanUtils.copyProperties(request, entity);

        entity = orderDataService.orderDataValidation(request, entity);

        logger.info(MESSAGE_PATTERN, ENTITY, entity);
        entity = orderRepository.save(entity);
        return modelBuilder.buildModel(entity, OrderModel.class);
    }

}
