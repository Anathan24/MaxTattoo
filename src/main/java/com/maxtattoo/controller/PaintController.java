package com.maxtattoo.controller;

import com.maxtattoo.command.SaveCmd;
import com.maxtattoo.command.DeleteByIdCmd;
import com.maxtattoo.command.FindAllCmd;
import com.maxtattoo.command.FindByIdCmd;
import com.maxtattoo.dto.entity.Paint;
import com.maxtattoo.dto.model.PaintModel;
import com.maxtattoo.dto.request.PaintRequest;
import com.maxtattoo.utils.GenericResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.maxtattoo.service.enums.Entity.PAINT;
import static com.maxtattoo.utils.StringUtils.*;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping(value = "/paint")
public class PaintController extends GenericController{

    @GetMapping(value = "/findById", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PaintModel> findById(@RequestParam Long id){
        logger.info(START);
        var command = super.beanFactory.getBean(FindByIdCmd.class);
        logger.info(MESSAGE_PATTERN, REQUEST, id);
        var model = command.execute(repositoryFactory.getRepository(PAINT), PaintModel.class, id);
        logger.info(MESSAGE_PATTERN, MODEL, model);
        logger.info(END);
        return ok(model);
    }

    @GetMapping(value = "/findAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PaintModel>> findAll(){
        logger.info(START);
        var command = super.beanFactory.getBean(FindAllCmd.class);
        var model = command.execute(repositoryFactory.getRepository(PAINT), PaintModel.class);
        logger.info(MESSAGE_PATTERN, MODEL, model);
        logger.info(END);
        return ok(model);
    }

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PaintModel> save(@RequestBody PaintRequest request){
        logger.info(START);
        var command = super.beanFactory.getBean(SaveCmd.class);
        var model = command.execute(repositoryFactory.getRepository(PAINT), Paint.class, PaintModel.class, request);
        logger.info(MESSAGE_PATTERN, MODEL, model);
        logger.info(END);
        return ok(model);
    }

    @DeleteMapping(value = "/deleteById")
    public ResponseEntity<GenericResponse> deleteById(@RequestParam("paintId") Long id){
        logger.info(START);
        var command = super.beanFactory.getBean(DeleteByIdCmd.class);
        logger.info(MESSAGE_PATTERN, REQUEST, id);
        var result = command.execute(repositoryFactory.getRepository(PAINT), PAINT, id);
        logger.info("RESULT: {}", result);
        logger.info(END);
        return ok(result);
    }

}
