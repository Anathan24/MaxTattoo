package com.maxtattoo.command;

import com.maxtattoo.service.ClientOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class ClientOrderCommand extends GenericCommand {

    @Autowired
    private ClientOrderService clientOrderService;

    public Long createClientOrderRelation(Long clientId, Long orderId){
        return clientOrderService.createClientOrderRelation(clientId, orderId);
    }
}
