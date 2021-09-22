package com.maxtattoo.command;

import com.maxtattoo.database.repository.CollectionRepository;
import com.maxtattoo.dto.entity.Collection;
import com.maxtattoo.dto.model.CollectionModel;
import com.maxtattoo.dto.request.CollectionRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static com.maxtattoo.utils.StringUtils.*;

@Component
@Scope("prototype")
public class SaveImageCmd extends GenericCommand {

    @Autowired
    private CollectionRepository collectionRepository;

    public CollectionModel execute(CollectionRequest request) {
        var entity = (Collection) entityFactory.getObject(Collection.class.getSimpleName());
        BeanUtils.copyProperties(request, entity);

        logger.info("{}: id: {}, name: {}, description: {}", ENTITY, entity.getImageId(), entity.getName(), entity.getDescription());
        entity = collectionRepository.save(entity);

        return modelBuilder.buildModel(entity, CollectionModel.class);
    }
}
