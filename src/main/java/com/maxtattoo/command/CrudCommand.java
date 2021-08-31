package com.maxtattoo.command;

import com.maxtattoo.database.repository.LocationRepository;
import com.maxtattoo.dto.entity.Client;
import com.maxtattoo.dto.request.ClientRequest;
import com.maxtattoo.dto.request.GenericRequest;
import com.maxtattoo.dto.request.OrderRequest;
import com.maxtattoo.dto.request.SittingRequest;
import com.maxtattoo.exception.ResourceNotFoundException;
import com.maxtattoo.service.DeleteForeignKeyService;
import com.maxtattoo.service.IdValidatorService;
import com.maxtattoo.service.enums.EntityName;
import com.maxtattoo.utils.GenericResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.maxtattoo.utils.StringUtils.ENTITY;
import static com.maxtattoo.utils.StringUtils.MESSAGE_PATTERN;

@Component
@Scope("prototype")
public class CrudCommand extends GenericCommand {

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private IdValidatorService idValidatorService;
    @Autowired
    private DeleteForeignKeyService deleteForeignKeyService;

    public  <INPUT, OUTPUT> OUTPUT findById(JpaRepository<INPUT, Long> repository, Class<OUTPUT> outputClass, Long id) {
        var entity = repository.findById(id);
        logger.info(MESSAGE_PATTERN, ENTITY, entity);

        if (entity.isPresent()) {
            return modelBuilder.buildModel(entity.get(), outputClass);
        } else {
            String message = "findById does not found any record with id(" + id + ")";
            logger.warn(message);
            throw new ResourceNotFoundException(message, HttpStatus.NOT_FOUND);
        }
    }

    public <INPUT, OUTPUT> List<OUTPUT> findAll(JpaRepository<INPUT, Long> repository, Class<OUTPUT> outputClass) {
        var entity = repository.findAll();
        logger.info(MESSAGE_PATTERN, ENTITY, entity);

       return modelBuilder.buildModel(entity, outputClass);
    }

    @SuppressWarnings("unchecked")
    public <INPUT, OUTPUT> OUTPUT save(JpaRepository<INPUT, Long> repository, Class<INPUT> inputClass, Class<OUTPUT> outputClass, GenericRequest request){
        var entity = (INPUT) entityFactory.getObject(inputClass.getSimpleName());
        BeanUtils.copyProperties(request, entity);

        if(request instanceof ClientRequest) {
            ClientRequest clientRequest = (ClientRequest)request;
            Client client = (Client) entity;
            idValidatorService.entityIdValidation(locationRepository, clientRequest.getLocationId());
            client.setLocation(locationRepository.getById(clientRequest.getLocationId()));
            //LocationId diventa obbligatorio per inserimento del cliente.
        }

        if(request instanceof OrderRequest){

        }

        if(request instanceof SittingRequest){

        }

        logger.info(MESSAGE_PATTERN, ENTITY, entity);
        entity = repository.save(entity);
        return modelBuilder.buildModel(entity, outputClass);
    }

    public <INPUT> GenericResponse deleteById(JpaRepository<INPUT, Long> repository, EntityName entityName, Long id) {
        var entityId = idValidatorService.entityIdValidation(repository, id);
        deleteForeignKeyService.controller(entityName, entityId);
        repository.deleteById(entityId);
        return GenericResponse.OK;
    }
}
