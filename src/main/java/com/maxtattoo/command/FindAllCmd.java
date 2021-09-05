package com.maxtattoo.command;

import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.maxtattoo.utils.StringUtils.ENTITY;
import static com.maxtattoo.utils.StringUtils.MESSAGE_PATTERN;

@Component
@Scope("prototype")
public class FindAllCmd extends GenericCommand {

    public <INPUT, OUTPUT> List<OUTPUT> execute(JpaRepository<INPUT, Long> repository, Class<OUTPUT> outputClass) {
        var entity = repository.findAll();
        logger.info(MESSAGE_PATTERN, ENTITY, entity);

        return modelBuilder.buildModel(entity, outputClass);
    }
}
