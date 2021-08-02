package com.maxtattoo.service;

import com.maxtattoo.builder.ModelBuilder;
import com.maxtattoo.utils.ErrorMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class GenericService {

    final Logger logger = LoggerFactory.getLogger(this.getClass());
    final String ENTITY_NAME = this.getClass().getSimpleName();

    @Autowired
    protected ModelBuilder modelBuilder;

    String buildErrorMessage(ErrorMessage message, Long entityId){
        String result = message.getValue().concat(ENTITY_NAME + "(" + entityId + ")");
        logger.info(result);
        return result;
    }
}
