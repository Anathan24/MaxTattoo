package com.maxtattoo.command;

import com.maxtattoo.builder.ListModelBuilder;
import com.maxtattoo.builder.ModelBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import static com.maxtattoo.utils.ErrorMessage.FIND_BY_ID;

abstract class GenericCommand {
    final Logger logger = LoggerFactory.getLogger(this.getClass());
    final String ENTITY = "ENTITY";
    final String MESSAGE_PATTERN = "{}: {}";

    @Autowired
    protected ModelBuilder modelBuilder;
    @Autowired
    protected ListModelBuilder listModelBuilder;

    String buildEntityNotFoundErrorMessage(String entityName, Long entityId){
        return FIND_BY_ID.getValue().concat(entityName + "(" + entityId + ")");
    }
}
