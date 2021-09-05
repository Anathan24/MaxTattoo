package com.maxtattoo.controller;

import com.maxtattoo.command.*;
import com.maxtattoo.dto.entity.Client;
import com.maxtattoo.dto.model.ClientModel;
import com.maxtattoo.dto.request.ClientRequest;
import com.maxtattoo.utils.GenericResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.maxtattoo.service.enums.EntityName.CLIENT;
import static com.maxtattoo.utils.StringUtils.*;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping(value = "/client")
public class ClientController extends GenericController {

    @GetMapping(value = "/findById", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ClientModel> findById(@RequestParam Long id) {
        logger.info(START);
        var command = beanFactory.getBean(FindByIdCmd.class);
        logger.info(MESSAGE_PATTERN, REQUEST, id);
        var model = command.execute(repositoryFactory.getRepository(CLIENT), ClientModel.class, id);
        logger.info(MESSAGE_PATTERN, MODEL, model);
        logger.info(END);
        return ok(model);
    }

    @GetMapping(value = "/findAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ClientModel>> findAll(){
        logger.info(START);
        var command = super.beanFactory.getBean(FindAllCmd.class);
        var result = command.execute(repositoryFactory.getRepository(CLIENT), ClientModel.class);
        logger.info(MESSAGE_PATTERN, MODEL, result);
        logger.info(END);
        return ok(result);
    }

    @GetMapping(value = "/findByNameAndSurname", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ClientModel>> findByNameAndSurname(@RequestParam String name, @RequestParam String surname) {
        logger.info(START);
        var command = beanFactory.getBean(FindClientCmd.class);
        logger.info("{} = name: {}, surname: {}",REQUEST, name, surname);
        var model = command.findByNameAndSurname(name, surname);
        logger.info(MESSAGE_PATTERN, MODEL, model);
        logger.info(END);
        return ok(model);
    }

    @GetMapping(value = "/findClientsByInitialLetters", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ClientModel>> findByInitialLetters(@RequestParam String initialLetters){
        logger.info(START);
        var command = beanFactory.getBean(FindClientCmd.class);
        logger.info(MESSAGE_PATTERN, REQUEST, initialLetters);
        var result = command.findByInitialLetters(initialLetters);
        logger.info("RESULT: {}", result);
        logger.info(END);
        return ok(result);
    }

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE,  produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ClientModel> save(@RequestBody ClientRequest request) {
        logger.info(START);
        var command = beanFactory.getBean(SaveCmd.class);
        logger.info(MESSAGE_PATTERN,REQUEST, request);
        var model = command.execute(repositoryFactory.getRepository(CLIENT), Client.class, ClientModel.class, request);
        logger.info(MESSAGE_PATTERN, MODEL, model);
        logger.info(END);
        return ok(model);
    }

    @DeleteMapping(value = "/deleteById")
    public ResponseEntity<GenericResponse> deleteById(@RequestParam("clientId") Long id){
        logger.info(START);
        var command = super.beanFactory.getBean(DeleteByIdCmd.class);
        logger.info(MESSAGE_PATTERN, REQUEST, id);
        var result = command.execute(repositoryFactory.getRepository(CLIENT), CLIENT, id);
        logger.info("RESULT: {}", result);
        logger.info(END);
        return ok(result);
    }
}
