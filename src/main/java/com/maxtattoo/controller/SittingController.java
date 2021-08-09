package com.maxtattoo.controller;

import com.maxtattoo.command.SittingCommand;
import com.maxtattoo.pojo.model.SittingModel;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping(value = "/sitting")
public class SittingController extends GenericController{

    @GetMapping(value = "/findById", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SittingModel> findById(@RequestParam Long id){
        logger.info(START);
        var command = super.beanFactory.getBean(SittingCommand.class);
        logger.info("{}: {}",REQUEST, id);
        var model = command.findById(id);
        logger.info(END);
        return ok(model);
    }
}
