package com.maxtattoo.controller;

import com.maxtattoo.command.NeedleCommand;
import com.maxtattoo.model.NeedleModel;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping(value = "/needle", produces = {MediaType.APPLICATION_JSON_VALUE, "application/hal+json"})
public class NeedleController extends GenericController{

    @GetMapping(value = "/findById")
    public ResponseEntity<NeedleModel> findById(@RequestParam Long id){
        var needleCommand = super.beanFactory.getBean(NeedleCommand.class);
        var needleModel = needleCommand.findById(id);
        return ok(needleModel);
    }
}
