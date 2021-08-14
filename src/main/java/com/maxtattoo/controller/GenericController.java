package com.maxtattoo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;

abstract class GenericController {
    final String START = "====================START====================";
    final String MESSAGE_PATTERN = "{}: {}";
    final String REQUEST = "REQUEST";
    final String MODEL = "MODEL";
    final String END = "=====================END====================";
    final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    BeanFactory beanFactory;

}
