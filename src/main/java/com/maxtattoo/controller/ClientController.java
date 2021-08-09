package com.maxtattoo.controller;

import com.maxtattoo.command.ClientCommand;
import com.maxtattoo.pojo.model.ClientModel;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping(value = "/client")
public class ClientController extends GenericController {

    @GetMapping(value = "/findById", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ClientModel> findById(@RequestParam Long id) {
        logger.info(START);
        var command = beanFactory.getBean(ClientCommand.class);
        logger.info("{}: {}",REQUEST, id);
        var model = command.findById(id);
        logger.info(END);
        return ok(model);
    }

    @GetMapping(value = "/findByNameAndSurname", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ClientModel>> findClientByNameAndSurname(@RequestParam String name, @RequestParam String surname) {
        logger.info(START);
        var command = beanFactory.getBean(ClientCommand.class);
        logger.info("{} = name: {}, surname: {}",REQUEST, name, surname);
        var model = command.findClientByNameAndSurname(name, surname);
        logger.info(END);
        return ok(model);
    }

}
