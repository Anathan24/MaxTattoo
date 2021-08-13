package com.maxtattoo.controller;

import com.maxtattoo.command.CityCommand;
import com.maxtattoo.pojo.model.CityModel;
import com.maxtattoo.pojo.request.CityRequest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping(value = "/city")
public class CityController extends GenericController {

    @GetMapping(value = "/findById", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CityModel> findById(@RequestParam Long id){
        logger.info(START);
        var command = beanFactory.getBean(CityCommand.class);
        logger.info("{} id: {}", REQUEST, id);
        var model = command.findById(id);
        logger.info(END);
        return ok(model);
    }

    @GetMapping(value = "/findAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CityModel>> findAllCities(){
        logger.info(START);
        var command = beanFactory.getBean(CityCommand.class);
        logger.info("{}", REQUEST);
        var model = command.findAll();
        logger.info(END);
        return ok(model);
    }

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CityModel> save(@RequestBody CityRequest request){
        logger.info(START);
        var command = super.beanFactory.getBean(CityCommand.class);
        logger.info("{} id: {}", REQUEST, request);
        var model = command.save(request);
        logger.info(END);
        return ok(model);
    }
}
