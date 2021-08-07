package com.maxtattoo.controller;

import com.maxtattoo.command.LocationCommand;
import com.maxtattoo.pojo.model.LocationModel;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping(value = "/location", produces = {MediaType.APPLICATION_JSON_VALUE, "application/hal+json"})
public class LocationController extends GenericController{

    @GetMapping( value = "/findById")
    public ResponseEntity<LocationModel> findById(@RequestParam Long id){
        var locationCommand = super.beanFactory.getBean(LocationCommand.class);
        var locationModel = locationCommand.findById(id);
        return ok(locationModel);
    }
}
