package com.maxtattoo.command;

import com.maxtattoo.builder.ListModelBuilder;
import com.maxtattoo.database.repository.ClientRepository;
import com.maxtattoo.exception.ResourceNotFoundException;
import com.maxtattoo.pojo.model.ClientModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("prototype")
public class ClientCommand extends GenericCommand {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ListModelBuilder listModelBuilder;

    public ClientModel findById(Long id) {
        var result = clientRepository.findById(id);
        logger.info("{}: {}", ENTITY, result);

        if (result.isPresent()) {
            return super.modelBuilder.createClientModel(result.get());
        }else {
            String message = super.buildEntityNotFoundErrorMessage(id);
            logger.warn(message);
            throw new ResourceNotFoundException(message, HttpStatus.NOT_FOUND);
        }
    }

    public List<ClientModel> findClientByNameAndSurname(String name, String surname) {
        //TODO da implementare il motore di ricerca
        var clientsEntity = clientRepository.findClientByNameAndSurname(name, surname);
        return listModelBuilder.createClientModel(clientsEntity);
    }

}
