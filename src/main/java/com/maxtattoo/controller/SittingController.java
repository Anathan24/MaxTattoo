package com.maxtattoo.controller;

import com.maxtattoo.command.SittingCommand;
import com.maxtattoo.model.SittingModel;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping(value = "/sitting", produces = {MediaType.APPLICATION_JSON_VALUE, "application/hal+json"})
public class SittingController extends GenericController{

    @GetMapping(value = "/findById")
    public ResponseEntity<SittingModel> findById(@RequestParam Long id){
        var sittingCommand = super.beanFactory.getBean(SittingCommand.class);
        var sittingModel = sittingCommand.findSittingById(id);
        return ok(sittingModel);
    }
}
