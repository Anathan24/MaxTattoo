package com.maxtattoo.command;

import com.maxtattoo.database.repository.PaintRepository;
import com.maxtattoo.exception.ResourceNotFoundException;
import com.maxtattoo.bean.entity.Paint;
import com.maxtattoo.bean.model.PaintModel;
import com.maxtattoo.bean.request.PaintRequest;
import com.maxtattoo.service.DeleteForeignKeyService;
import com.maxtattoo.service.IdValidatorService;
import com.maxtattoo.utils.GenericResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("prototype")
public class PaintCommand extends GenericCommand{

    @Autowired
    private PaintRepository paintRepository;

    @Autowired
    private IdValidatorService idValidatorService;
    @Autowired
    private DeleteForeignKeyService deleteForeignKeyService;

    public PaintModel findById(Long id){
        var result = paintRepository.findById(id);
        logger.info(MESSAGE_PATTERN, ENTITY, result);

        if(result.isPresent()) {
            return super.modelBuilder.createPaintModel(result.get());
        }else{
            String message = super.buildEntityNotFoundErrorMessage(Paint.class.getSimpleName(), id);
            logger.warn(message);
            throw new ResourceNotFoundException(message, HttpStatus.NOT_FOUND);
        }
    }

    public List<PaintModel> findAll(){
        var result = paintRepository.findAll();
        logger.info(MESSAGE_PATTERN, ENTITY, result);
        return super.listModelBuilder.createListPaintModel(result);
    }

    public PaintModel save(PaintRequest request){
        var entity = (Paint) entityFactory.getObject(Paint.class.getSimpleName());
        BeanUtils.copyProperties(request, entity);

        logger.info(MESSAGE_PATTERN, ENTITY, entity);
        entity = paintRepository.save(entity);
        return super.modelBuilder.createPaintModel(entity);
    }

    public GenericResponse deleteById(Long id){
        var paintId = idValidatorService.paintIdValidation(id);
        deleteForeignKeyService.deleteSittingPaintRelationByPaintId(paintId);
        paintRepository.deleteById(paintId);
        return GenericResponse.OK;
    }
}
