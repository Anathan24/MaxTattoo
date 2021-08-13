package com.maxtattoo.controller;

import com.maxtattoo.command.NeedleCommand;
import com.maxtattoo.pojo.model.NeedleModel;
import com.maxtattoo.pojo.request.NeedleRequest;
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
        logger.info(END);
        return ok(model);
    }

    @GetMapping(value = "/findAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<NeedleModel>> findAll(){
        logger.info(START);
        var command = super.beanFactory.getBean(NeedleCommand.class);
        logger.info("{}", REQUEST);
        var model = command.findAll();
        logger.info(END);
        return ok(model);
    }

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<NeedleModel> save(@RequestBody NeedleRequest request){
        logger.info(START);
        var command = super.beanFactory.getBean(NeedleCommand.class);
        logger.info("{}: {}", REQUEST, request);
        var model = command.save(request);
        logger.info(END);
        return ok(model);
    }
}
