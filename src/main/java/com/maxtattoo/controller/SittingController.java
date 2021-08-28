package com.maxtattoo.controller;

import com.maxtattoo.command.CrudCommand;
import com.maxtattoo.command.SittingCommand;
import com.maxtattoo.database.repository.SittingRepository;
import com.maxtattoo.dto.model.SittingModel;
import com.maxtattoo.dto.request.SittingRequest;
import com.maxtattoo.utils.GenericResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping(value = "/sitting")
public class SittingController extends GenericController{

    @Autowired
    private SittingRepository sittingRepository;

    @GetMapping(value = "/findById", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SittingModel> findById(@RequestParam Long id){
        logger.info(START);
        var command = super.beanFactory.getBean(CrudCommand.class);
        logger.info(MESSAGE_PATTERN, REQUEST, id);
        var model = command.findById(sittingRepository, SittingModel.class, id);
        logger.info(MESSAGE_PATTERN, MODEL, model);
        logger.info(END);
        return ok(model);
    }

    @GetMapping(value = "/findAllSittingStates", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<String>> findAllSittingStates(){
        logger.info(START);
        var command = super.beanFactory.getBean(SittingCommand.class);
        var result = command.findAllSittingStates();
        logger.info("RESULT: {}", result);
        logger.info(END);
        return ok(result);
    }

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SittingModel> save(@RequestBody SittingRequest request,
                                             @RequestParam(name = "paintId", required = false) List<Long> paints,
                                             @RequestParam(name = "needleId", required = false) List<Long> needles){
        logger.info(START);
        var command = super.beanFactory.getBean(SittingCommand.class);
        logger.info("{}: {}", REQUEST, request);
        var model = command.save(request, paints, needles);
        logger.info(MESSAGE_PATTERN, MODEL, model);
        logger.info(END);
        return ok(model);
    }

    @DeleteMapping(value = "/deleteById")
    public ResponseEntity<GenericResponse> deleteById(@RequestParam("sittingId") Long id){
        logger.info(START);
        var command = super.beanFactory.getBean(CrudCommand.class);
        logger.info(MESSAGE_PATTERN, REQUEST, id);
        var result = command.deleteById(sittingRepository, "Sitting", id);
        logger.info("RESULT: {}", result);
        logger.info(END);
        return ok(result);
    }
}
