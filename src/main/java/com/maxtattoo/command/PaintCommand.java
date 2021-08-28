package com.maxtattoo.command;

import com.maxtattoo.database.repository.PaintRepository;
import com.maxtattoo.dto.entity.Paint;
import com.maxtattoo.dto.model.PaintModel;
import com.maxtattoo.dto.request.PaintRequest;
import com.maxtattoo.service.DeleteForeignKeyService;
import com.maxtattoo.service.IdValidatorService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class PaintCommand extends GenericCommand{

    @Autowired
    private PaintRepository paintRepository;

    @Autowired
    private IdValidatorService idValidatorService;
    @Autowired
    private DeleteForeignKeyService deleteForeignKeyService;

    public PaintModel save(PaintRequest request){
        var entity = (Paint) entityFactory.getObject(Paint.class.getSimpleName());
        BeanUtils.copyProperties(request, entity);

        logger.info(MESSAGE_PATTERN, ENTITY, entity);
        entity = paintRepository.save(entity);
        return super.modelBuilder.createPaintModel(entity);
    }
}
