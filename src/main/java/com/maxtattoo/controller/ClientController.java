package com.maxtattoo.controller;

import com.maxtattoo.command.ClientCommand;
import com.maxtattoo.model.ClientModel;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping(value = "/client", produces = {MediaType.APPLICATION_JSON_VALUE, "application/hal+json"})
public class ClientController extends GenericController {

    @Autowired
    private BeanFactory beanFactory;

    @GetMapping(value = "/id/{id}")
    public ResponseEntity<ClientModel> findClientById(@PathVariable Long id) {
        var clientCommand = beanFactory.getBean(ClientCommand.class);
        var clientModel = clientCommand.findClientById(id);
        return ok(clientModel);
    }

    @GetMapping(value = "/name/{name}/surname/{surname}")
    public ResponseEntity<List<ClientModel>> findClientByNameAndSurname(@PathVariable String name, @PathVariable String surname) {
        var clientCommand = beanFactory.getBean(ClientCommand.class);
        var clientsModel = clientCommand.findClientByNameAndSurname(name, surname);
        return ok(clientsModel);
    }

}
