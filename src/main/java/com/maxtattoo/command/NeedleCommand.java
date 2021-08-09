package com.maxtattoo.command;

import com.maxtattoo.database.repository.NeedleRepository;
import com.maxtattoo.exception.ResourceNotFoundException;
import com.maxtattoo.pojo.entity.Needle;
import com.maxtattoo.pojo.model.NeedleModel;
import com.maxtattoo.pojo.request.NeedleRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class NeedleCommand extends GenericCommand {

    @Autowired
    private NeedleRepository needleRepository;

    public NeedleModel findById(Long id) {
        var result = needleRepository.findById(id);
        logger.info("{}: {}", ENTITY, result);

        if(result.isPresent()) {
            return super.modelBuilder.createNeedleModel(result.get());
        }else{
            String message = super.buildEntityNotFoundErrorMessage(id);
            logger.warn(message);
            throw new ResourceNotFoundException(message, HttpStatus.NOT_FOUND);
        }
    }

    public NeedleModel saveNeedle(NeedleRequest request){
        var entity = new Needle();
        BeanUtils.copyProperties(request, entity);
        logger.info("{}: {}", ENTITY, entity);

        entity = needleRepository.save(entity);
        return super.modelBuilder.createNeedleModel(entity);
    }
}
