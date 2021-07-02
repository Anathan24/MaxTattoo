package com.maxtattoo.service.interfaces;

import com.maxtattoo.builder.ModelBuilder;
import com.maxtattoo.builder.ResponseBuilder;
import com.maxtattoo.database.entity.repository.ClientRepository;
import com.maxtattoo.response.ClientResponse;
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
    @Autowired
    private ResponseBuilder responseBuilder;

    public ClientResponse getAllClientData(Long clientId){
        logger.info("Go to get client entity from database...");
        var clientEntity = clientRepository.findClientById(clientId);
        logger.info("Transform client entity into model...");
        var clientModer = modelBuilder.createClientModel(clientEntity);
        logger.info("Generating response with all client data...");
        return responseBuilder.createClientResponse(clientModer);
    }

}
