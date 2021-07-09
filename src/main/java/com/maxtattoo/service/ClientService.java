package com.maxtattoo.service;

import com.maxtattoo.database.repository.ClientRepository;
import com.maxtattoo.model.ClientModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService extends GenericService{

    @Autowired
    private ClientRepository clientRepository;

    public ClientModel findClientById(Long clientId){
        var clientEntity = clientRepository.findClientById(clientId);
        return super.modelBuilder.createClientModel(clientEntity);
    }

    public List<ClientModel> findClientByNameAndSurname(String name, String surname){
        var clientsEntity = clientRepository.findClientByNameAndSurname(name, surname);
        return super.modelBuilder.createClientModel(clientsEntity);
    }

}
