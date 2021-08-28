package com.maxtattoo.command;

import com.maxtattoo.database.repository.NeedleRepository;
import com.maxtattoo.dto.entity.Needle;
import com.maxtattoo.dto.model.NeedleModel;
import com.maxtattoo.dto.request.NeedleRequest;
import com.maxtattoo.service.DeleteForeignKeyService;
import com.maxtattoo.service.IdValidatorService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class NeedleCommand extends GenericCommand {

    @Autowired
    private NeedleRepository needleRepository;

    @Autowired
    private IdValidatorService idValidatorService;
    @Autowired
    private DeleteForeignKeyService deleteForeignKeyService;

    public NeedleModel save(NeedleRequest request){
        var entity = (Needle) entityFactory.getObject(Needle.class.getSimpleName());
        BeanUtils.copyProperties(request, entity);

        logger.info(MESSAGE_PATTERN, ENTITY, entity);
        entity = needleRepository.save(entity);
        return modelBuilder.buildModel(entity, NeedleModel.class);
    }
}
