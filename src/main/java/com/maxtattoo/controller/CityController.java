package com.maxtattoo.controller;

import com.maxtattoo.command.DeleteByIdCmd;
import com.maxtattoo.command.FindAllCmd;
import com.maxtattoo.command.FindByIdCmd;
import com.maxtattoo.command.SaveCmd;
import com.maxtattoo.database.repository.CityRepository;
import com.maxtattoo.dto.entity.City;
import com.maxtattoo.dto.model.CityModel;
import com.maxtattoo.dto.request.CityRequest;
import com.maxtattoo.utils.GenericResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.maxtattoo.service.enums.Entity.CITY;
import static com.maxtattoo.utils.StringUtils.*;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping(value = "/city")
public class CityController extends GenericController {

    @Autowired
    private CityRepository cityRepository;

    @GetMapping(value = "/findById", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CityModel> findById(@RequestParam Long id) {
        logger.info(START);
        var command = beanFactory.getBean(FindByIdCmd.class);
        logger.info(MESSAGE_PATTERN, REQUEST, id);
        var model = command.execute(cityRepository, CityModel.class, id);
        logger.info(MESSAGE_PATTERN, MODEL, model);
        logger.info(END);
        return ok(model);
    }

    @GetMapping(value = "/findAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CityModel>> findAll() {
        logger.info(START);
        var command = beanFactory.getBean(FindAllCmd.class);
        var model = command.execute(cityRepository, CityModel.class);
        logger.info(MESSAGE_PATTERN, MODEL, model);
        logger.info(END);
        return ok(model);
    }

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CityModel> save(@RequestBody CityRequest request) {
        logger.info(START);
        var command = beanFactory.getBean(SaveCmd.class);
        logger.info("{} id: {}", REQUEST, request);
        var model = command.execute(cityRepository, City.class, CityModel.class, request);
        logger.info(MESSAGE_PATTERN, MODEL, model);
        logger.info(END);
        return ok(model);
    }

    @DeleteMapping(value = "/deleteById", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponse> deleteById(@RequestParam(name = "cityId") Long id) {
        logger.info(START);
        var command = beanFactory.getBean(DeleteByIdCmd.class);
        logger.info(MESSAGE_PATTERN, REQUEST, id);
        var result = command.execute(cityRepository, CITY, id);
        logger.info("RESULT: {}", result);
        logger.info(END);
        return ok(result);
    }
}
