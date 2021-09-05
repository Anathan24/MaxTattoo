package com.maxtattoo.command;

import com.maxtattoo.database.repository.LocationRepository;
import com.maxtattoo.dto.entity.Client;
import com.maxtattoo.dto.entity.Order;
import com.maxtattoo.dto.request.ClientRequest;
import com.maxtattoo.dto.request.GenericRequest;
import com.maxtattoo.dto.request.OrderRequest;
import com.maxtattoo.service.OrderDataService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import static com.maxtattoo.utils.StringUtils.ENTITY;
import static com.maxtattoo.utils.StringUtils.MESSAGE_PATTERN;

@Component
@Scope("prototype")
public class SaveCmd extends GenericCommand {

    @Autowired
    private LocationRepository locationRepository;
    @Autowired
    private OrderDataService orderDataService;

    @SuppressWarnings("unchecked")
    public <INPUT, OUTPUT> OUTPUT execute(JpaRepository<INPUT, Long> repository, Class<INPUT> inputClass, Class<OUTPUT> outputClass, GenericRequest request){
        var entity = (INPUT) entityFactory.getObject(inputClass.getSimpleName());
        BeanUtils.copyProperties(request, entity);

        if(request instanceof ClientRequest) {
            ClientRequest clientRequest = (ClientRequest) request;
            Client client = (Client) entity;
            client.setLocation(clientRequest.getLocationId() == null ? null : locationRepository.getById(clientRequest.getLocationId()));
        }

        if(request instanceof OrderRequest) {
            OrderRequest orderRequest = (OrderRequest) request;
            Order order = (Order) entity;
            entity = (INPUT) orderDataService.orderDataValidation(orderRequest, order);
        }

        logger.info(MESSAGE_PATTERN, ENTITY, entity);
        entity = repository.save(entity);
        return modelBuilder.buildModel(entity, outputClass);
    }
}
