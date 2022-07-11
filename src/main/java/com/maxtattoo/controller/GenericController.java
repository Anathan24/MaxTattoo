package com.maxtattoo.controller;

import com.maxtattoo.factory.RepositoryFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:8080")
abstract class GenericController {

    final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    BeanFactory beanFactory;
    @Autowired
    RepositoryFactory repositoryFactory;

}
