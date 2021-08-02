package com.maxtattoo.service;

import com.maxtattoo.builder.ModelBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

abstract class GenericService{

    final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    protected ModelBuilder modelBuilder;

    public String buildEntityId(String entityName, Long id){
        return entityName + "(" + id + ")";
    }
}
