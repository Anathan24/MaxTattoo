package com.maxtattoo.controller;

import com.maxtattoo.command.CrudCommand;
import com.maxtattoo.command.PaintCommand;
import com.maxtattoo.database.repository.PaintRepository;
import com.maxtattoo.dto.model.PaintModel;
import com.maxtattoo.dto.request.PaintRequest;
import com.maxtattoo.service.enums.Entity;
import com.maxtattoo.utils.GenericResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.maxtattoo.utils.StringUtils.*;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping(value = "/paint")
public class PaintController extends GenericController{

    @Autowired
    private PaintRepository paintRepository;

    @GetMapping(value = "/findById", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PaintModel> findById(@RequestParam Long id){
        logger.info(START);
        var command = super.beanFactory.getBean(CrudCommand.class);
        logger.info(MESSAGE_PATTERN, REQUEST, id);
        var model = command.findById(paintRepository, PaintModel.class, id);
        logger.info(MESSAGE_PATTERN, MODEL, model);
        logger.info(END);
        return ok(model);
    }

    @GetMapping(value = "/findAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PaintModel>> findAll(){
        logger.info(START);
        var command = super.beanFactory.getBean(CrudCommand.class);
        var model = command.findAll(paintRepository, PaintModel.class);
        logger.info(MESSAGE_PATTERN, MODEL, model);
        logger.info(END);
        return ok(model);
    }

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PaintModel> save(@RequestBody PaintRequest request){
        logger.info(START);
        var command = super.beanFactory.getBean(PaintCommand.class);
        var model = command.save(request);
        logger.info(MESSAGE_PATTERN, MODEL, model);
        logger.info(END);
        return ok(model);
    }

    @DeleteMapping(value = "/deleteById")
    public ResponseEntity<GenericResponse> deleteById(@RequestParam("paintId") Long id){
        logger.info(START);
        var command = super.beanFactory.getBean(CrudCommand.class);
        logger.info(MESSAGE_PATTERN, REQUEST, id);
        var result = command.deleteById(paintRepository, Entity.PAINT, id);
        logger.info("RESULT: {}", result);
        logger.info(END);
        return ok(result);
    }

}
