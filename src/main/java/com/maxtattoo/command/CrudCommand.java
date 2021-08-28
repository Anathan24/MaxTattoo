package com.maxtattoo.command;

import com.maxtattoo.builder.ModelBuilder;
import com.maxtattoo.exception.ResourceNotFoundException;
import com.maxtattoo.service.DeleteForeignKeyService;
import com.maxtattoo.service.IdValidatorService;
import com.maxtattoo.utils.GenericResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("prototype")
public class CrudCommand {

    final Logger logger = LoggerFactory.getLogger(this.getClass());
    final String MESSAGE_PATTERN = "{}: {}";
    final String ENTITY = "ENTITY";

    @Autowired
    protected ModelBuilder modelBuilder;

    @Autowired
    private IdValidatorService idValidatorService;
    @Autowired
    private DeleteForeignKeyService deleteForeignKeyService;

    public  <INPUT, OUTPUT> OUTPUT findById(JpaRepository<INPUT, Long> repository, Class<OUTPUT> output, Long id) {
        var entity = repository.findById(id);
        logger.info(MESSAGE_PATTERN, ENTITY, entity);

        if (entity.isPresent()) {
            return modelBuilder.buildModel(entity.get(), output);
        } else {
            String message = "findById does not found any record with id(" + id + ")";
            logger.warn(message);
            throw new ResourceNotFoundException(message, HttpStatus.NOT_FOUND);
        }
    }

    public <INPUT, OUTPUT> List<OUTPUT> findAll(JpaRepository<INPUT, Long> repository, Class<OUTPUT> output) {
        var entity = repository.findAll();
        logger.info(MESSAGE_PATTERN, ENTITY, entity);

       return modelBuilder.buildListModel(entity, output);
    }

    public <INPUT> GenericResponse deleteById(JpaRepository<INPUT, Long> repository, String entityName, Long id) {
        var entityId = idValidatorService.entityIdValidation(repository, id);
        deleteForeignKeyService.controller(entityName, entityId);
        repository.deleteById(entityId);
        return GenericResponse.OK;
    }
}
