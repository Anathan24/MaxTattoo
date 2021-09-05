package com.maxtattoo.command;

import com.maxtattoo.database.repository.ClientRepository;
import com.maxtattoo.dto.model.ClientModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.maxtattoo.utils.StringUtils.ENTITY;
import static com.maxtattoo.utils.StringUtils.MESSAGE_PATTERN;

@Component
@Scope("prototype")
public class FindClientCmd extends GenericCommand {

    @Autowired
    private ClientRepository clientRepository;

    public List<ClientModel> findByNameAndSurname(String name, String surname) {
        var result = clientRepository.findByNameAndSurname(name, surname);
        logger.info(MESSAGE_PATTERN, ENTITY, result);
        return modelBuilder.buildModel(result, ClientModel.class);
    }

    public List<ClientModel> findByInitialLetters(String initialLetters){
        var result = clientRepository.findByInitialLetters(initialLetters);
        logger.info(MESSAGE_PATTERN, ENTITY, result);
        return modelBuilder.buildModel(result, ClientModel.class);
    }
}
