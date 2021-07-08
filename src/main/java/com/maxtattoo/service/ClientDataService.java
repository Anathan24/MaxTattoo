package com.maxtattoo.service;

import com.maxtattoo.builder.ModelBuilder;
import com.maxtattoo.database.repository.ClientRepository;
import com.maxtattoo.model.ClientModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientDataService {

    private static final Logger logger = LoggerFactory.getLogger(ClientDataService.class);

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ModelBuilder modelBuilder;

    public ClientModel getAllClientData(Long clientId){
        logger.info("Go to get client entity from database...");
        var clientEntity = clientRepository.findClientById(clientId);
        logger.info("Transform client entity into model...");
        return modelBuilder.createClientModel(clientEntity);
    }

}
