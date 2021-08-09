package com.maxtattoo.controller;

import com.maxtattoo.command.PaintCommand;
import com.maxtattoo.pojo.model.PaintModel;
import com.maxtattoo.pojo.request.PaintRequest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping(value = "/paint")
public class PaintController extends GenericController{

    @GetMapping(value = "/findById", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PaintModel> findById(@RequestParam Long id){
        logger.info(START);
        var command = super.beanFactory.getBean(PaintCommand.class);
        logger.info("{} id: {}", REQUEST, id);
        var model = command.findById(id);
        logger.info(END);
        return ok(model);
    }

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PaintModel> savePaint(@RequestBody PaintRequest request){
        logger.info(START);
        var command = super.beanFactory.getBean(PaintCommand.class);
        var model = command.savePaint(request);
        logger.info(END);
        return ok(model);
    }

}
