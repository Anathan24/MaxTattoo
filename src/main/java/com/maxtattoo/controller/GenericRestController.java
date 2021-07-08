package com.maxtattoo.controller;

import com.maxtattoo.database.entity.Client;
import com.maxtattoo.database.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GenericRestController {

    @Autowired
    private ClientRepository clientRepository;

    public GenericRestController(@Autowired ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }

    @GetMapping("/client")
    public Client getClientById(){
        Client client = clientRepository.findClientById(1L);
        return client;
    }
}
