package com.maxtattoo.command;

import com.maxtattoo.model.ClientModel;
import com.maxtattoo.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("prototype")
public class ClientCommand extends GenericCommand {

    @Autowired
    private ClientService clientDataService;

    public ClientModel findClientById(Long id){
        return clientDataService.findClientById(id);
    }

    public List<ClientModel> findClientByNameAndSurname(String name, String surname){
        return clientDataService.findClientByNameAndSurname(name, surname);
    }

}
