package com.maxtattoo.command;

import com.maxtattoo.service.DeleteForeignKeyService;
import com.maxtattoo.service.IdValidatorService;
import com.maxtattoo.service.enums.Entity;
import com.maxtattoo.utils.GenericResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class DeleteByIdCmd extends GenericCommand {

    @Autowired
    private IdValidatorService idValidatorService;
    @Autowired
    private DeleteForeignKeyService deleteForeignKeyService;

    public <INPUT> GenericResponse execute(JpaRepository<INPUT, Long> repository, Entity entityName, Long id) {
        var entityId = idValidatorService.entityIdValidation(repository, id);
        deleteForeignKeyService.controller(entityName, entityId);
        repository.deleteById(entityId);
        return GenericResponse.OK;
    }
}
