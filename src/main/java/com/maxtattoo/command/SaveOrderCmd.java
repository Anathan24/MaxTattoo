package com.maxtattoo.command;

import com.maxtattoo.database.repository.ClientRepository;
import com.maxtattoo.database.repository.OrderRepository;
import com.maxtattoo.database.repository.OrderTypeRepository;
import com.maxtattoo.dto.entity.Order;
import com.maxtattoo.dto.entity.OrderType;
import com.maxtattoo.dto.request.OrderRequest;
import com.maxtattoo.exception.ResourceNotFoundException;
import com.maxtattoo.service.IdValidatorService;
import com.maxtattoo.service.OrderStateManagerService;
import com.maxtattoo.service.enums.OrderState;
import com.maxtattoo.utils.DateUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.sql.Date;

import static com.maxtattoo.utils.StringUtils.ENTITY;
import static com.maxtattoo.utils.StringUtils.MESSAGE_PATTERN;

@Component
@Scope("prototype")
public class SaveOrderCmd extends GenericCommand {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderTypeRepository orderTypeRepository;

    @Autowired
    private IdValidatorService idValidatorService;
    @Autowired
    private OrderStateManagerService orderStateManagerService;

    public <OUTPUT> OUTPUT execute(Class<OUTPUT> outputClass, OrderRequest orderRequest) {
        var entity = (Order) entityFactory.getObject(Order.class.getSimpleName());
        Date startDate = DateUtils.getDateFromString(orderRequest.getStartDate());
        Date endEnd = DateUtils.getDateFromString(orderRequest.getEndDate());

        BeanUtils.copyProperties(orderRequest, entity);
        DateUtils.checkForStartDateNoGreaterThenEndDate(startDate, endEnd);

        entity.setStartDate(startDate);
        entity.setEndDate(endEnd);
        entity.setOrderType(orderTypeValidation(orderRequest.getOrderType()));
        entity.setClientId(idValidatorService.entityIdValidation(clientRepository, orderRequest.getClientId()));

        if(orderRequest.getOrderId() == null) {
            entity.setOrderState(OrderState.findByValue(orderRequest.getOrderState()) == null ? OrderState.PREVIEW.getValue() : orderRequest.getOrderState());
        } else {
            idValidatorService.entityIdValidation(orderRepository, entity.getOrderId());
            orderStateManagerService.checkForNoStateRegression(entity.getOrderId(),entity.getOrderState());
            orderStateManagerService.checkForFinishedOrderState(entity);
        }

        logger.info(MESSAGE_PATTERN, ENTITY, entity);
        entity = orderRepository.save(entity);
        return modelBuilder.buildModel(entity, outputClass);
    }

    private OrderType orderTypeValidation(String orderType) {
        if (orderType != null && orderTypeRepository.orderTypeExistsByValue(orderType) != null) {
            return orderTypeRepository.findOrderTypeByValue(orderType);
        } else {
            String message = "Request parameter orderType("+orderType+") not found! Insert an existing order type.";
            logger.warn(message);
            throw new ResourceNotFoundException(message, HttpStatus.NOT_FOUND);
        }
    }
}
