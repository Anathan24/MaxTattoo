package com.maxtattoo.controller;

import com.maxtattoo.command.NeedleCommand;
import com.maxtattoo.bean.model.NeedleModel;
import com.maxtattoo.bean.request.NeedleRequest;
import com.maxtattoo.utils.GenericResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping(value = "/needle")
public class NeedleController extends GenericController{

    @GetMapping(value = "/findById", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<NeedleModel> findById(@RequestParam Long id){
        logger.info(START);
        var command = super.beanFactory.getBean(NeedleCommand.class);
        logger.info("{} id: {}", REQUEST, id);
        var model = command.findById(id);
        logger.info(MESSAGE_PATTERN, MODEL, model);
        logger.info(END);
        return ok(model);
    }

    @GetMapping(value = "/findAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<NeedleModel>> findAll(){
        logger.info(START);
        var command = super.beanFactory.getBean(NeedleCommand.class);
        var model = command.findAll();
        logger.info(MESSAGE_PATTERN, MODEL, model);
        logger.info(END);
        return ok(model);
    }

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<NeedleModel> save(@RequestBody NeedleRequest request){
        logger.info(START);
        var command = super.beanFactory.getBean(NeedleCommand.class);
        logger.info("{}: {}", REQUEST, request);
        var model = command.save(request);
        logger.info(MESSAGE_PATTERN, MODEL, model);
        logger.info(END);
        return ok(model);
    }

    @DeleteMapping(value = "/deleteById")
    public ResponseEntity<GenericResponse> deleteById(@RequestParam("needleId") Long id){
        logger.info(START);
        var command = super.beanFactory.getBean(NeedleCommand.class);
        logger.info(MESSAGE_PATTERN, REQUEST, id);
        var result = command.deleteById(id);
        logger.info("RESULT: {}", result);
        logger.info(END);
        return ok(result);
    }
}
