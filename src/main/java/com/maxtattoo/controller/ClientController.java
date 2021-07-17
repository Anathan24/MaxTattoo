package com.maxtattoo.controller;

import com.maxtattoo.command.ClientCommand;
import com.maxtattoo.model.ClientModel;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping(value = "/client", produces = {MediaType.APPLICATION_JSON_VALUE, "application/hal+json"})
public class ClientController extends GenericController {

    @GetMapping(value = "/findClientById")
    public ResponseEntity<ClientModel> findClientById(@RequestParam Long id) {
        var clientCommand = beanFactory.getBean(ClientCommand.class);
        var clientModel = clientCommand.findClientById(id);
        return ok(clientModel);
    }

    @GetMapping(value = "/findClientByNameAndSurname")
    public ResponseEntity<List<ClientModel>> findClientByNameAndSurname(@RequestParam String name, @RequestParam String surname) {
        var clientCommand = beanFactory.getBean(ClientCommand.class);
        var clientsModel = clientCommand.findClientByNameAndSurname(name, surname);
        return ok(clientsModel);
    }

}
