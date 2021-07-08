package com.maxtattoo.controller;

import com.maxtattoo.command.ClientDataCommand;
import com.maxtattoo.model.ClientModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping(produces = {MediaType.APPLICATION_JSON_VALUE, "application/hal+json"})
public class GenericRestController {

    private static final Logger logger = LoggerFactory.getLogger(GenericRestController.class);

    @Autowired
    private BeanFactory getBean;

    @GetMapping(value = "/client")
    public ResponseEntity<ClientModel> allClientData(@RequestParam Long id){
        logger.info("Invoked allClientData method of controller");
        ClientDataCommand clientCommand = getBean.getBean(ClientDataCommand.class, id);
        var clientModel = clientCommand.execute();
        return ok(clientModel);
    }

}
