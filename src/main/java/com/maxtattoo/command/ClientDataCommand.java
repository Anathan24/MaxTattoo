package com.maxtattoo.command;

import com.maxtattoo.model.ClientModel;
import com.maxtattoo.service.ClientDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class ClientDataCommand {

    private final Long id;

    @Autowired
    private ClientDataService clientDataService;

    public ClientDataCommand(Long id){
        this.id = id;
    }

    public ClientModel execute(){
        return clientDataService.getAllClientData(id);
    }

}
