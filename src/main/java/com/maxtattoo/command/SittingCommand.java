package com.maxtattoo.command;

import com.maxtattoo.database.repository.*;
import com.maxtattoo.exception.ResourceNotFoundException;
import com.maxtattoo.pojo.entity.Sitting;
import com.maxtattoo.pojo.entity.SittingNeedle;
import com.maxtattoo.pojo.entity.SittingPaint;
import com.maxtattoo.pojo.model.SittingModel;
import com.maxtattoo.pojo.request.SittingRequest;
import com.maxtattoo.service.DataValidatorService;
import com.maxtattoo.service.DeleteForeignKeyRelationService;
import com.maxtattoo.service.IdValidatorService;
import com.maxtattoo.utils.DateUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("prototype")
public class SittingCommand extends GenericCommand {

    @Autowired
    private SittingRepository sittingRepository;
    @Autowired
    private SittingPaintRepository sittingPaintRepository;
    @Autowired
    private SittingNeedleRepository sittingNeedleRepository;

    @Autowired
    private DataValidatorService dataValidatorService;
    @Autowired
    private IdValidatorService idValidatorService;
    @Autowired
    private DeleteForeignKeyRelationService deleteForeignKeyRelationService;

    public SittingModel findById(Long id) {
        var result = sittingRepository.findById(id);
        logger.info(MESSAGE_PATTERN, ENTITY, result);

        if(result.isPresent()) {
            return super.modelBuilder.createSittingModel(result.get());
        }else{
            String message = super.buildEntityNotFoundErrorMessage(Sitting.class.getSimpleName(), id);
            logger.warn(message);
            throw new ResourceNotFoundException(message, HttpStatus.NOT_FOUND);
        }
    }

    public SittingModel save(SittingRequest request, List<Long> paints, List<Long> needles) {
        var entity = (Sitting) entityFactory.getObject(Sitting.class.getSimpleName());
        BeanUtils.copyProperties(request, entity);

        entity.setDate(DateUtils.getTimestampFromString(request.getDate()));
        entity.setSittingState(dataValidatorService.sittingStateValidation(request.getState()));
        entity.setOrderId(idValidatorService.orderIdValidation(request.getOrderId()));

        logger.info(MESSAGE_PATTERN, ENTITY, entity);
        entity = sittingRepository.save(entity);

        saveSittingPaintRelation(entity.getId(), paints);
        saveSittingNeedleRelation(entity.getId(), needles);

        return super.modelBuilder.createSittingModel(entity);
    }

    public String deleteById(Long id) {
        var sittingId = idValidatorService.sittingIdValidation(id);
        deleteForeignKeyRelationService.deleteSittingPaintRelationBySittingId(sittingId);
        deleteForeignKeyRelationService.deleteSittingNeedleRelationBySittingId(sittingId);
        sittingRepository.deleteById(sittingId);
        return "OK";
    }

    private void saveSittingPaintRelation(Long sittingId, List<Long> paints){
        if(paints != null){
            paints.forEach(paint -> {
                var entity = (SittingPaint)entityFactory.getObject(SittingPaint.class.getSimpleName());
                entity.setSittingIdFk(sittingId);
                entity.setPaintIdFk(paint);
                sittingPaintRepository.save(entity);
            });
        }
    }

    private void saveSittingNeedleRelation(Long sittingId, List<Long> needles){
        if(needles != null){
            needles.forEach(needle -> {
                var entity = (SittingNeedle) entityFactory.getObject(SittingNeedle.class.getSimpleName());
                entity.setSittingIdFk(sittingId);
                entity.setNeedleIdFk(needle);
                sittingNeedleRepository.save(entity);
            });
        }
    }

}
