package com.maxtattoo.command;

import com.maxtattoo.database.repository.ClientRepository;
import com.maxtattoo.database.repository.LocationRepository;
import com.maxtattoo.exception.ResourceNotFoundException;
import com.maxtattoo.bean.entity.Client;
import com.maxtattoo.bean.model.ClientModel;
import com.maxtattoo.bean.request.ClientRequest;
import com.maxtattoo.service.DeleteForeignKeyService;
import com.maxtattoo.service.IdValidatorService;
import com.maxtattoo.utils.GenericResponse;
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

    @Autowired
    private IdValidatorService idValidatorService;
    @Autowired
    private DeleteForeignKeyService deleteForeignKeyService;

    public ClientModel findById(Long id) {
        var entity = clientRepository.findById(id);
        logger.info(MESSAGE_PATTERN, ENTITY, entity);

        if (entity.isPresent()) {
            return super.modelBuilder.createClientModel(entity.get());
        }else {
            String message = super.buildEntityNotFoundErrorMessage(Client.class.getSimpleName(), id);
            logger.warn(message);
            throw new ResourceNotFoundException(message, HttpStatus.NOT_FOUND);
        }
    }

    public List<ClientModel> findAll() {
        var entity = clientRepository.findAll();
        logger.info(MESSAGE_PATTERN, ENTITY, entity);

        return super.listModelBuilder.createListClientModel(entity);
    }

    public List<ClientModel> findClientByNameAndSurname(String name, String surname) {
        var clientsEntity = clientRepository.findClientByNameAndSurname(name, surname);
        return super.listModelBuilder.createListClientModel(clientsEntity);
    }

    public ClientModel save(ClientRequest request) {
        var entity = (Client) entityFactory.getObject(Client.class.getSimpleName());

        if(request.getLocationId() != null && locationRepository.existsById(request.getLocationId())){
            entity.setLocation(locationRepository.getById(request.getLocationId()));
        } else {
            logger.info("REQUEST PARAMETER locationId({}) DOES NOT EXIST!",request.getLocationId());
        }

        BeanUtils.copyProperties(request, entity);
        logger.info(MESSAGE_PATTERN, ENTITY, entity);
        entity = clientRepository.save(entity);

        return super.modelBuilder.createClientModel(entity);
    }

    public GenericResponse deleteById(Long id) {
        var clientId = idValidatorService.clientIdValidation(id);
        deleteForeignKeyService.deleteOrdersClientFk(clientId);
        clientRepository.deleteById(clientId);
        return GenericResponse.OK;
    }

}
