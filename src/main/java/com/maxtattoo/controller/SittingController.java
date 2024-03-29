package com.maxtattoo.controller;

import com.maxtattoo.command.DeleteByIdCmd;
import com.maxtattoo.command.FindByIdCmd;
import com.maxtattoo.command.SaveSittingCmd;
import com.maxtattoo.dto.model.SittingModel;
import com.maxtattoo.dto.request.SittingRequest;
import com.maxtattoo.service.enums.SittingState;
import com.maxtattoo.utils.GenericResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.maxtattoo.service.enums.Entity.SITTING;
import static com.maxtattoo.utils.StringUtils.*;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping(value = "/sitting")
public class SittingController extends GenericController {

    @GetMapping(value = "/findById", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SittingModel> findById(@RequestParam Long id){
        logger.info(START);
        var command = super.beanFactory.getBean(FindByIdCmd.class);
        logger.info(MESSAGE_PATTERN, REQUEST, id);
        var model = command.execute(repositoryFactory.getRepository(SITTING), SittingModel.class, id);
        logger.info(MESSAGE_PATTERN, MODEL, model);
        logger.info(END);
        return ok(model);
    }

    @GetMapping(value = "/findAllSittingStates", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<String>> findAllSittingStates(){
        logger.info(START);
        var result = Arrays.stream(SittingState.values()).map(SittingState::getValue).collect(Collectors.toCollection(ArrayList::new));
        logger.info("RESULT: {}", result);
        logger.info(END);
        return ok(result);
    }

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SittingModel> save(@RequestBody SittingRequest request,
                                             @RequestParam(name = "paintId", required = false) List<Long> paints,
                                             @RequestParam(name = "needleId", required = false) List<Long> needles){
        logger.info(START);
        var command = super.beanFactory.getBean(SaveSittingCmd.class);
        logger.info("{}: {}", REQUEST, request);
        var model = command.execute(request, paints, needles);
        logger.info(MESSAGE_PATTERN, MODEL, model);
        logger.info(END);
        return ok(model);
    }

    @DeleteMapping(value = "/deleteById")
    public ResponseEntity<GenericResponse> deleteById(@RequestParam("sittingId") Long id){
        logger.info(START);
        var command = super.beanFactory.getBean(DeleteByIdCmd.class);
        logger.info(MESSAGE_PATTERN, REQUEST, id);
        var result = command.execute(repositoryFactory.getRepository(SITTING), SITTING, id);
        logger.info("RESULT: {}", result);
        logger.info(END);
        return ok(result);
    }
}
