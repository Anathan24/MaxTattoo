package com.maxtattoo.service;

import com.maxtattoo.exception.ResourceNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class IdValidatorService extends GenericService {

    public <INPUT> Long entityIdValidation(JpaRepository<INPUT, Long> repository, Long entityId) {
        if(entityId != null && repository.existsById(entityId)) {
            return entityId;
        } else {
            String message = "Request parameter EntityId("+entityId+") not found! Insert an existing entity id.";
            logger.info(message);
            throw new ResourceNotFoundException(message, HttpStatus.NOT_FOUND);
        }
    }
}
