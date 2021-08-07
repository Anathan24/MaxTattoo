package com.maxtattoo.controller;

import com.maxtattoo.command.CityCommand;
import com.maxtattoo.pojo.model.CityModel;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping(value = "/city", produces = {MediaType.APPLICATION_JSON_VALUE, "application/hal+json"})
public class CityController extends GenericController {

    @GetMapping(value = "/findById")
    public ResponseEntity<CityModel> findById(@RequestParam Long id){
        var cityCommand = beanFactory.getBean(CityCommand.class);
        var cityModel = cityCommand.findById(id);
        return ok(cityModel);
    }
}
