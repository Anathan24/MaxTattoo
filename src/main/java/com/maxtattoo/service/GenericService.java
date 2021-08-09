package com.maxtattoo.service;

import com.maxtattoo.builder.ModelBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import static com.maxtattoo.utils.ErrorMessage.FIND_BY_ID;

public abstract class GenericService {

    final Logger logger = LoggerFactory.getLogger(this.getClass());
    final String ENTITY_NAME = this.getClass().getSimpleName();
    final String ENTITY = "ENTITY";

    @Autowired
    protected ModelBuilder modelBuilder;

    String buildEntityNotFoundErrorMessage(Long entityId){
        return FIND_BY_ID.getValue().concat(ENTITY_NAME + "(" + entityId + ")");
    }
}
