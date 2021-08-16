package com.maxtattoo.command;

import com.maxtattoo.database.repository.OrderRepository;
import com.maxtattoo.database.repository.OrderTypeRepository;
import com.maxtattoo.exception.ResourceNotFoundException;
import com.maxtattoo.pojo.entity.Order;
import com.maxtattoo.pojo.entity.OrderType;
import com.maxtattoo.pojo.model.OrderModel;
import com.maxtattoo.pojo.model.OrderTypeModel;
import com.maxtattoo.pojo.request.OrderRequest;
import com.maxtattoo.pojo.request.OrderTypeRequest;
import com.maxtattoo.service.DataValidatorService;
import com.maxtattoo.service.DeleteForeignKeyRelationService;
import com.maxtattoo.service.IdValidatorService;
import com.maxtattoo.utils.DateUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.List;

@Component
@Scope("prototype")
public class OrderCommand extends GenericCommand {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderTypeRepository orderTypeRepository;

    @Autowired
    private DataValidatorService dataValidatorService;
    @Autowired
    private IdValidatorService idValidatorService;
    @Autowired
    private DeleteForeignKeyRelationService deleteForeignKeyRelationService;

    public OrderModel findById(Long id) {
        var entity = orderRepository.findById(id);
        logger.info(MESSAGE_PATTERN, ENTITY, entity);

        if(entity.isPresent()) {
            return super.modelBuilder.createOrderModel(entity.get());
        }else{
            String message = super.buildEntityNotFoundErrorMessage(Order.class.getSimpleName(), id);
            logger.warn(message);
            throw new ResourceNotFoundException(message, HttpStatus.NOT_FOUND);
        }
    }

    public OrderTypeModel findOrderTypeById(Long id){
        var result = orderTypeRepository.findById(id);
        logger.info(MESSAGE_PATTERN, ENTITY, result);

        if(result.isPresent()) {
            return super.modelBuilder.createOrderTypeModel(result.get());
        }else{
            String message = super.buildEntityNotFoundErrorMessage(OrderType.class.getSimpleName(), id);
            logger.warn(message);
            throw new ResourceNotFoundException(message, HttpStatus.NOT_FOUND);
        }
    }

    public List<OrderModel> findAll(){
        var entity = orderRepository.findAll();
        logger.info(MESSAGE_PATTERN, ENTITY, entity);
        return super.listModelBuilder.createListOrderModel(entity);
    }

    public List<OrderTypeModel> findAllOrderTypes(){
        var result = orderTypeRepository.findAll();
        logger.info(MESSAGE_PATTERN, ENTITY, result);
        return listModelBuilder.createListOrderTypeModel(result);
    }

    public OrderModel save(OrderRequest request) {
        Date startDate = DateUtils.getDateFromString(request.getStartDate());
        Date endDate = DateUtils.getDateFromString(request.getEndDate());
        dataValidatorService.startDateNotGreaterThenEndDateValidation(startDate, endDate);

        var entity = (Order) entityFactory.getObject(Order.class.getSimpleName());
        BeanUtils.copyProperties(request, entity);

        entity.setStartDate(startDate);
        entity.setEndDate(endDate);
        entity.setClientId(idValidatorService.clientIdValidation(request.getClientId()));
        entity.setOrderType(dataValidatorService.orderTypeValidation(request.getOrderType()));

        logger.info(MESSAGE_PATTERN, ENTITY, entity);
        entity = orderRepository.save(entity);
        return super.modelBuilder.createOrderModel(entity);
    }

    public OrderTypeModel saveOrderType(OrderTypeRequest request){
        var entity = (OrderType) entityFactory.getObject(OrderType.class.getSimpleName());
        BeanUtils.copyProperties(request, entity);

        logger.info(MESSAGE_PATTERN, ENTITY, entity);
        entity = orderTypeRepository.save(entity);
        return super.modelBuilder.createOrderTypeModel(entity);
    }

    public String deleteById(Long id){
        var orderId = idValidatorService.orderIdValidation(id);
        orderRepository.deleteById(orderId);
        return "OK";
    }

    public String deleteOrderTypeById(Long typeId){
        var orderTypeId = idValidatorService.orderTypeIdValidation(typeId);
        deleteForeignKeyRelationService.deleteOrderOrderTypeRelationByOrderTypeId(orderTypeId);
        orderTypeRepository.deleteById(orderTypeId);
        return "OK";
    }
}
