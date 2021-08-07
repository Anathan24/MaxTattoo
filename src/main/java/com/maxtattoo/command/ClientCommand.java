package com.maxtattoo.command;

import com.maxtattoo.pojo.model.ClientModel;
import com.maxtattoo.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("prototype")
public class ClientCommand extends GenericCommand {

    @Autowired
    private ClientService clientService;

    public ClientModel findById(Long id){
        return clientService.findById(id);
    }

    public List<ClientModel> findClientByNameAndSurname(String name, String surname){
        return clientService.findClientByNameAndSurname(name, surname);
    }

}
