package com.maxtattoo.command;

import com.maxtattoo.exception.ResourceNotFoundException;
import com.maxtattoo.service.DeleteForeignKeyService;
import com.maxtattoo.service.IdValidatorService;
import com.maxtattoo.service.enums.Entity;
import com.maxtattoo.utils.GenericResponse;
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

       return modelBuilder.buildModel(entity, output);
    }

    public <INPUT> GenericResponse deleteById(JpaRepository<INPUT, Long> repository, Entity entityName, Long id) {
        var entityId = idValidatorService.entityIdValidation(repository, id);
        deleteForeignKeyService.controller(entityName, entityId);
        repository.deleteById(entityId);
        return GenericResponse.OK;
    }
}
