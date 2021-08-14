package com.maxtattoo.controller;

import com.maxtattoo.command.SittingCommand;
import com.maxtattoo.pojo.model.SittingModel;
import com.maxtattoo.pojo.request.SittingRequest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping(value = "/sitting")
public class SittingController extends GenericController{

    @GetMapping(value = "/findById", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SittingModel> findById(@RequestParam Long id){
        logger.info(START);
        var command = super.beanFactory.getBean(SittingCommand.class);
        logger.info("{}: {}",REQUEST, id);
        var model = command.findById(id);
        logger.info(MESSAGE_PATTERN, MODEL, model);
        logger.info(END);
        return ok(model);
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
}
