package com.maxtattoo.command;

import com.maxtattoo.model.ClientModel;
import com.maxtattoo.service.ClientDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClientDataCommand {


    @Autowired
    private ClientDataService clientDataService;


    public ClientModel execute(Long clientId){
        return clientDataService.getAllClientData(clientId);
    }

}
