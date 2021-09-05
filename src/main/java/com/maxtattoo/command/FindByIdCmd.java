package com.maxtattoo.command;

import com.maxtattoo.exception.ResourceNotFoundException;
import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import static com.maxtattoo.utils.StringUtils.ENTITY;
import static com.maxtattoo.utils.StringUtils.MESSAGE_PATTERN;

@Component
@Scope("prototype")
public class FindByIdCmd extends GenericCommand {

    public  <INPUT, OUTPUT> OUTPUT execute(JpaRepository<INPUT, Long> repository, Class<OUTPUT> outputClass, Long id) {
        var entity = repository.findById(id);
        logger.info(MESSAGE_PATTERN, ENTITY, entity);

        if (entity.isPresent()) {
            return modelBuilder.buildModel(entity.get(), outputClass);
        } else {
            String message = "findById does not found any record with id(" + id + ")";
            logger.warn(message);
            throw new ResourceNotFoundException(message, HttpStatus.NOT_FOUND);
        }
    }
}
