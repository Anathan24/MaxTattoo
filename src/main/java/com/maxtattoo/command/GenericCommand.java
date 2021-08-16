package com.maxtattoo.command;

import com.maxtattoo.builder.ListModelBuilder;
import com.maxtattoo.builder.ModelBuilder;
import com.maxtattoo.factory.AbstractFactory;
import com.maxtattoo.factory.EntityFactory;
import com.maxtattoo.factory.FactoryProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

abstract class GenericCommand {
    final Logger logger = LoggerFactory.getLogger(this.getClass());
    final AbstractFactory entityFactory = FactoryProducer.getFactory(EntityFactory.class.getSimpleName());
    final String ENTITY = "ENTITY";
    final String MESSAGE_PATTERN = "{}: {}";

    @Autowired
    protected ModelBuilder modelBuilder;
    @Autowired
    protected ListModelBuilder listModelBuilder;

    String buildEntityNotFoundErrorMessage(String entityName, Long entityId){
        return "findById does not found any record for entity: "+entityName + " with id(" + entityId + ")";
    }
}
