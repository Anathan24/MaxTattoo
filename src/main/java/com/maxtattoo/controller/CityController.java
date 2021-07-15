package com.maxtattoo.controller;

import com.maxtattoo.command.CityCommand;
import com.maxtattoo.model.CityModel;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private BeanFactory beanFactory;

    @GetMapping(value = "/findCityById")
    public ResponseEntity<CityModel> findCityById(@RequestParam Long id){
        var cityCommand = beanFactory.getBean(CityCommand.class);
        var cityModel = cityCommand.findCityById(id);
        return ok(cityModel);
    }
}
