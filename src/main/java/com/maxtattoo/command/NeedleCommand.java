package com.maxtattoo.command;

import com.maxtattoo.database.repository.NeedleRepository;
import com.maxtattoo.exception.ResourceNotFoundException;
import com.maxtattoo.bean.entity.Needle;
import com.maxtattoo.bean.model.NeedleModel;
import com.maxtattoo.bean.request.NeedleRequest;
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
public class NeedleCommand extends GenericCommand {

    @Autowired
    private NeedleRepository needleRepository;

    @Autowired
    private IdValidatorService idValidatorService;
    @Autowired
    private DeleteForeignKeyService deleteForeignKeyService;

    public NeedleModel findById(Long id) {
        var result = needleRepository.findById(id);
        logger.info(MESSAGE_PATTERN, ENTITY, result);

        if(result.isPresent()) {
            return super.modelBuilder.createNeedleModel(result.get());
        }else{
            String message = super.buildEntityNotFoundErrorMessage(Needle.class.getSimpleName(), id);
            logger.warn(message);
            throw new ResourceNotFoundException(message, HttpStatus.NOT_FOUND);
        }
    }

    public List<NeedleModel> findAll(){
        var result = needleRepository.findAll();
        logger.info(MESSAGE_PATTERN, ENTITY, result);
        return super.listModelBuilder.createListNeedleModel(result);
    }

    public NeedleModel save(NeedleRequest request){
        var entity = (Needle) entityFactory.getObject(Needle.class.getSimpleName());
        BeanUtils.copyProperties(request, entity);

        logger.info(MESSAGE_PATTERN, ENTITY, entity);
        entity = needleRepository.save(entity);
        return super.modelBuilder.createNeedleModel(entity);
    }

    public GenericResponse deleteById(Long id){
        var needleId = idValidatorService.needleIdValidation(id);
        deleteForeignKeyService.deleteSittingNeedleRelationByNeedleId(needleId);
        needleRepository.deleteById(needleId);
        return GenericResponse.OK;
    }
}
