package com.maxtattoo.controller;

import com.maxtattoo.command.LocationCommand;
import com.maxtattoo.pojo.model.LocationModel;
import com.maxtattoo.pojo.request.LocationRequest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping(value = "/location", produces = {MediaType.APPLICATION_JSON_VALUE, "application/hal+json"})
public class LocationController extends GenericController{

    @GetMapping( value = "/findById")
    public ResponseEntity<LocationModel> findById(@RequestParam Long id){
        logger.info(START);
        var command = super.beanFactory.getBean(LocationCommand.class);
        var model = command.findById(id);
        logger.info(END);
        return ok(model);
    }

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LocationModel> saveLocation(@RequestBody LocationRequest request){
        logger.info(START);
        var command = super.beanFactory.getBean(LocationCommand.class);
        var model = command.saveLocation(request);
        logger.info(END);
        return ok(model);
    }
}
