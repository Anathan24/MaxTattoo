package com.maxtattoo.command;

import com.maxtattoo.database.repository.ClientRepository;
import com.maxtattoo.database.repository.LocationRepository;
import com.maxtattoo.dto.entity.Client;
import com.maxtattoo.dto.model.ClientModel;
import com.maxtattoo.dto.request.ClientRequest;
import com.maxtattoo.service.DeleteForeignKeyService;
import com.maxtattoo.service.IdValidatorService;
import com.maxtattoo.utils.GenericResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
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

    public List<ClientModel> findByNameAndSurname(String name, String surname) {
        var result = clientRepository.findByNameAndSurname(name, surname);
        logger.info(MESSAGE_PATTERN, ENTITY, result);
        return modelBuilder.buildListModel(result, ClientModel.class);
    }

    public List<ClientModel> findByInitialLetters(String initialLetters){
        var result = clientRepository.findByInitialLetters(initialLetters);
        logger.info(MESSAGE_PATTERN, ENTITY, result);
        return modelBuilder.buildListModel(result, ClientModel.class);
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
