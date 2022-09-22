package com.maxtattoo.controller;

import com.maxtattoo.command.DeleteByIdCmd;
import com.maxtattoo.command.FindAllCmd;
import com.maxtattoo.command.FindByIdCmd;
import com.maxtattoo.command.SaveLocationCmd;
import com.maxtattoo.database.repository.LocationRepository;
import com.maxtattoo.dto.model.LocationModel;
import com.maxtattoo.dto.request.LocationRequest;
import com.maxtattoo.utils.GenericResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.maxtattoo.service.enums.Entity.LOCATION;
import static com.maxtattoo.utils.StringUtils.*;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping(value = "/location")
public class LocationController extends GenericController {

    @Autowired
    private LocationRepository locationRepository;

    @GetMapping(value = "/findById", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LocationModel> findById(@RequestParam Long id) {
        logger.info(START);
        var command = super.beanFactory.getBean(FindByIdCmd.class);
        var model = command.execute(locationRepository, LocationModel.class, id);
        logger.info(MESSAGE_PATTERN, MODEL, model);
        logger.info(END);
        return ok(model);
    }

    @GetMapping(value = "/findAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<LocationModel>> findAll() {
        logger.info(START);
        var command = super.beanFactory.getBean(FindAllCmd.class);
        logger.info("{}", REQUEST);
        var model = command.execute(locationRepository, LocationModel.class);
        logger.info(MESSAGE_PATTERN, MODEL, model);
        logger.info(END);
        return ok(model);
    }

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LocationModel> save(@RequestBody LocationRequest request,
                                              @RequestParam(name = "cityId", required = false) List<Long> cities) {
        logger.info(START);
        var command = super.beanFactory.getBean(SaveLocationCmd.class);
        logger.info("{}: {}; {}: {}", REQUEST, request, "Cities Id", cities);
        var model = command.execute(request, cities);
        logger.info(MESSAGE_PATTERN, MODEL, model);
        logger.info(END);
        return ok(model);
    }

    @DeleteMapping(value = "/deleteById", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponse> deleteById(@RequestParam(name = "locationId") Long id) {
        logger.info(START);
        var command = super.beanFactory.getBean(DeleteByIdCmd.class);
        logger.info(MESSAGE_PATTERN, REQUEST, id);
        var result = command.execute(locationRepository, LOCATION, id);
        logger.info("RESULT: {}", result);
        logger.info(END);
        return ok(result);
    }
}
