package com.maxtattoo.controller;

import com.maxtattoo.command.SaveCmd;
import com.maxtattoo.command.DeleteByIdCmd;
import com.maxtattoo.command.FindAllCmd;
import com.maxtattoo.command.FindByIdCmd;
import com.maxtattoo.dto.entity.Needle;
import com.maxtattoo.dto.model.NeedleModel;
import com.maxtattoo.dto.request.NeedleRequest;
import com.maxtattoo.utils.GenericResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.maxtattoo.service.enums.EntityName.NEEDLE;
import static com.maxtattoo.utils.StringUtils.*;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping(value = "/needle")
public class NeedleController extends GenericController{

    @GetMapping(value = "/findById", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<NeedleModel> findById(@RequestParam Long id){
        logger.info(START);
        var command = beanFactory.getBean(FindByIdCmd.class);
        logger.info(MESSAGE_PATTERN , REQUEST, id);
        var model = command.execute(repositoryFactory.getRepository(NEEDLE), NeedleModel.class, id);
        logger.info(MESSAGE_PATTERN, MODEL, model);
        logger.info(END);
        return ok(model);
    }

    @GetMapping(value = "/findAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<NeedleModel>> findAll(){
        logger.info(START);
        var command = beanFactory.getBean(FindAllCmd.class);
        var model = command.execute(repositoryFactory.getRepository(NEEDLE), NeedleModel.class);
        logger.info(MESSAGE_PATTERN, MODEL, model);
        logger.info(END);
        return ok(model);
    }

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<NeedleModel> save(@RequestBody NeedleRequest request){
        logger.info(START);
        var command = beanFactory.getBean(SaveCmd.class);
        logger.info("{}: {}", REQUEST, request);
        var model = command.execute(repositoryFactory.getRepository(NEEDLE), Needle.class, NeedleModel.class, request);
        logger.info(MESSAGE_PATTERN, MODEL, model);
        logger.info(END);
        return ok(model);
    }

    @DeleteMapping(value = "/deleteById")
    public ResponseEntity<GenericResponse> deleteById(@RequestParam("needleId") Long id) {
        logger.info(START);
        var command = beanFactory.getBean(DeleteByIdCmd.class);
        logger.info(MESSAGE_PATTERN, REQUEST, id);
        var result = command.execute(repositoryFactory.getRepository(NEEDLE), NEEDLE, id);
        logger.info("RESULT: {}", result);
        logger.info(END);
        return ok(result);
    }
}
