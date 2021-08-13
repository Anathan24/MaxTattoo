package com.maxtattoo.command;

import com.maxtattoo.database.repository.ClientRepository;
import com.maxtattoo.database.repository.LocationRepository;
import com.maxtattoo.exception.ResourceNotFoundException;
import com.maxtattoo.pojo.EntityFactory;
import com.maxtattoo.pojo.entity.Client;
import com.maxtattoo.pojo.model.ClientModel;
import com.maxtattoo.pojo.request.ClientRequest;
import org.springframework.beans.BeanUtils;
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
    private LocationRepository locationRepository;

    public ClientModel findById(Long id) {
        var result = clientRepository.findById(id);
        logger.info(MESSAGE_PATTERN, ENTITY, result);

        if (result.isPresent()) {
            return super.modelBuilder.createClientModel(result.get());
        }else {
            String message = super.buildEntityNotFoundErrorMessage(Client.class.getSimpleName(), id);
            logger.warn(message);
            throw new ResourceNotFoundException(message, HttpStatus.NOT_FOUND);
        }
    }

    public List<ClientModel> findAll(){
        var result = clientRepository.findAll();
        logger.info(MESSAGE_PATTERN, ENTITY, result);
        return super.listModelBuilder.createClientModel(result);
    }

    public List<ClientModel> findClientByNameAndSurname(String name, String surname) {
        //TODO da implementare il motore di ricerca
        var clientsEntity = clientRepository.findClientByNameAndSurname(name, surname);
        return super.listModelBuilder.createClientModel(clientsEntity);
    }

    public ClientModel save(ClientRequest request){
        var entity = (Client)EntityFactory.getEntity(Client.class.getSimpleName());

        if(request.getLocationId() != null && locationRepository.existsById(request.getLocationId())){
            entity.setLocation(locationRepository.getById(request.getLocationId()));
        } else {
            logger.info("LOCATION ID({}) DOES NOT EXIST!",request.getLocationId());
        }

        BeanUtils.copyProperties(request, entity);
        logger.info("{}: {}", ENTITY, entity);
        entity = clientRepository.save(entity);
        return super.modelBuilder.createClientModel(entity);
    }

}
