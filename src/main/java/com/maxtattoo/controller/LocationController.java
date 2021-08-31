package com.maxtattoo.controller;

import com.maxtattoo.command.CrudCommand;
import com.maxtattoo.command.LocationCommand;
import com.maxtattoo.dto.model.LocationModel;
import com.maxtattoo.dto.request.LocationRequest;
import com.maxtattoo.utils.GenericResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.maxtattoo.service.enums.EntityName.LOCATION;
import static com.maxtattoo.utils.StringUtils.*;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping(value = "/location")
public class LocationController extends GenericController {

    @GetMapping( value = "/findById", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LocationModel> findById(@RequestParam Long id){
        logger.info(START);
        var command = super.beanFactory.getBean(CrudCommand.class);
        var model = command.findById(repositoryFactory.getRepository(LOCATION), LocationModel.class, id);
        logger.info(MESSAGE_PATTERN, MODEL, model);
        logger.info(END);
        return ok(model);
    }

    @GetMapping(value = "/findAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<LocationModel>> findAll(){
        logger.info(START);
        var command = super.beanFactory.getBean(CrudCommand.class);
        logger.info("{}", REQUEST);
        var model = command.findAll(repositoryFactory.getRepository(LOCATION), LocationModel.class);
        logger.info(MESSAGE_PATTERN, MODEL, model);
        logger.info(END);
        return ok(model);
    }

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LocationModel> save(@RequestBody LocationRequest request,
                                              @RequestParam(name = "cityId", required = false) List<Long> cities){
        logger.info(START);
        var command = super.beanFactory.getBean(LocationCommand.class);
        logger.info("{}: {}; {}: {}", REQUEST, request, "Cities Id", cities);
        var model = command.save(request, cities);
        logger.info(MESSAGE_PATTERN, MODEL, model);
        logger.info(END);
        return ok(model);
    }

    @DeleteMapping(value = "/deleteById", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponse> deleteById(@RequestParam(name = "locationId") Long id){
        logger.info(START);
        var command = super.beanFactory.getBean(CrudCommand.class);
        logger.info(MESSAGE_PATTERN, REQUEST, id);
        var result = command.deleteById(repositoryFactory.getRepository(LOCATION), LOCATION, id);
        logger.info("RESULT: {}", result);
        logger.info(END);
        return ok(result);
    }
}
