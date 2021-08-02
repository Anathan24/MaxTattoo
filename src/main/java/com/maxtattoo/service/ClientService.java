package com.maxtattoo.service;

import com.maxtattoo.builder.ListModelBuilder;
import com.maxtattoo.database.entity.Client;
import com.maxtattoo.database.repository.ClientRepository;
import com.maxtattoo.exception.ResourceNotFoundException;
import com.maxtattoo.model.ClientModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.maxtattoo.utils.ErrorMessages.FIND_BY_ID;

@Service
public class ClientService extends GenericService{

    private static final String ENTITY_NAME = Client.class.getSimpleName();

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ListModelBuilder listModelBuilder;

    public ClientModel findById(Long id){
        var result = clientRepository.findById(id);

        if(result.isPresent())
            return super.modelBuilder.createClientModel(result.get());
        else
            throw new ResourceNotFoundException(FIND_BY_ID.getValue().concat(super.buildEntityId(ENTITY_NAME, id)), HttpStatus.NOT_FOUND);
    }

    public List<ClientModel> findClientByNameAndSurname(String name, String surname){
        var clientsEntity = clientRepository.findClientByNameAndSurname(name, surname);
        return listModelBuilder.createClientModel(clientsEntity);
    }
}
