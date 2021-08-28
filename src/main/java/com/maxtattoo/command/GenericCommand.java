package com.maxtattoo.command;

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
    final String MESSAGE_PATTERN = "{}: {}";
    final String ENTITY = "ENTITY";

    @Autowired
    protected ModelBuilder modelBuilder;

}
