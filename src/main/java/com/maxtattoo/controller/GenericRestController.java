package com.maxtattoo.controller;

import com.maxtattoo.command.ClientDataCommand;
import com.maxtattoo.model.ClientModel;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("client")
public class GenericRestController {

    @Autowired
    private final BeanFactory getBean;

    public GenericRestController(@Autowired BeanFactory beanFactory){
        this.getBean = beanFactory;
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<ClientModel> allClientData(@PathVariable("id") Long id){
        ClientDataCommand clientCommand = getBean.getBean(ClientDataCommand.class);
        var clientModel = clientCommand.execute(id);
        return new ResponseEntity<>(clientModel, HttpStatus.OK);
    }

}
