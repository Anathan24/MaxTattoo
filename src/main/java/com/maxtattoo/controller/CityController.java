package com.maxtattoo.controller;

import com.maxtattoo.command.CityCommand;
import com.maxtattoo.pojo.model.CityModel;
import com.maxtattoo.pojo.request.CityRequest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping(value = "/city")
public class CityController extends GenericController {

    @GetMapping(value = "/findById", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CityModel> findById(@RequestParam Long id){
        logger.info(START);
        var cityCommand = beanFactory.getBean(CityCommand.class);
        var cityModel = cityCommand.findById(id);
        logger.info(END);
        return ok(cityModel);
    }

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CityModel> saveCity(@RequestBody CityRequest request){
        logger.info(START);
        var command = super.beanFactory.getBean(CityCommand.class);
        var model = command.saveCity(request);
        logger.info(END);
        return ok(model);
    }
}
