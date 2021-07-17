package com.maxtattoo.controller;

import com.maxtattoo.command.ClientOrderCommand;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping(value = "/clientOrder", produces = {MediaType.APPLICATION_JSON_VALUE, "application/hal+json"})
public class ClientOrderController extends GenericController {

    @PostMapping(value = "/createClientOrderRelation")
    public ResponseEntity<Long> createClientOrderRelation(@RequestParam Long clientId, @RequestParam Long orderId){
        var clientOrderCommand = beanFactory.getBean(ClientOrderCommand.class);
        var relationId = clientOrderCommand.createClientOrderRelation(clientId, orderId);
        return ok(relationId);
    }
}
