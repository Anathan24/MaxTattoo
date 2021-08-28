package com.maxtattoo.controller;

import com.maxtattoo.command.CityCommand;
import com.maxtattoo.command.CrudCommand;
import com.maxtattoo.dto.model.CityModel;
import com.maxtattoo.dto.request.CityRequest;
import com.maxtattoo.service.enums.Entity;
import com.maxtattoo.utils.GenericResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.maxtattoo.utils.StringUtils.*;
import static org.springframework.http.ResponseEntity.ok;
import static com.maxtattoo.service.enums.Entity.CITY;

@RestController
@RequestMapping(value = "/city")
public class CityController extends GenericController {

    @GetMapping(value = "/findById", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CityModel> findById(@RequestParam Long id){
        logger.info(START);
        var command = beanFactory.getBean(CrudCommand.class);
        logger.info(MESSAGE_PATTERN, REQUEST, id);
        var model = command.findById(repositoryFactory.getRepository(CITY), CityModel.class, id);
        logger.info(MESSAGE_PATTERN, MODEL, model);
        logger.info(END);
        return ok(model);
    }

    @GetMapping(value = "/findAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CityModel>> findAll(){
        logger.info(START);
        var command = beanFactory.getBean(CrudCommand.class);
        var model = command.findAll(repositoryFactory.getRepository(CITY), CityModel.class);
        logger.info(MESSAGE_PATTERN, MODEL, model);
        logger.info(END);
        return ok(model);
    }

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CityModel> save(@RequestBody CityRequest request){
        logger.info(START);
        var command = super.beanFactory.getBean(CityCommand.class);
        logger.info("{} id: {}", REQUEST, request);
        var model = command.save(request);
        logger.info(MESSAGE_PATTERN, MODEL, model);
        logger.info(END);
        return ok(model);
    }

    @DeleteMapping(value = "/deleteById", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponse> deleteById(@RequestParam(name = "cityId") Long id){
        logger.info(START);
        var command = super.beanFactory.getBean(CrudCommand.class);
        logger.info(MESSAGE_PATTERN, REQUEST, id);
        var result = command.deleteById(repositoryFactory.getRepository(CITY), Entity.CITY, id);
        logger.info("RESULT: {}", result);
        logger.info(END);
        return ok(result);
    }
}
