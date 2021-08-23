package com.maxtattoo.command;

import com.maxtattoo.database.repository.*;
import com.maxtattoo.exception.ResourceNotFoundException;
import com.maxtattoo.dto.entity.Sitting;
import com.maxtattoo.dto.entity.SittingNeedle;
import com.maxtattoo.dto.entity.SittingPaint;
import com.maxtattoo.dto.model.SittingModel;
import com.maxtattoo.dto.request.SittingRequest;
import com.maxtattoo.service.DeleteForeignKeyService;
import com.maxtattoo.service.IdValidatorService;
import com.maxtattoo.service.enums.SittingState;
import com.maxtattoo.utils.DateUtils;
import com.maxtattoo.utils.GenericResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
    private IdValidatorService idValidatorService;
    @Autowired
    private DeleteForeignKeyService deleteForeignKeyService;

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

    public List<String> findAllSittingStates(){
        return Arrays.stream(SittingState.values())
                .map(SittingState::getValue)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public SittingModel save(SittingRequest request, List<Long> paints, List<Long> needles) {
        var entity = (Sitting) entityFactory.getObject(Sitting.class.getSimpleName());
        BeanUtils.copyProperties(request, entity);

        entity.setDateTime(DateUtils.getTimestampFromString(request.getDate()));
        entity.setSittingState(SittingState.findByValue(request.getSittingState()) == null ? SittingState.TO_DO.getValue() : request.getSittingState());
        entity.setOrderId(idValidatorService.orderIdValidation(request.getOrderId()));

        logger.info(MESSAGE_PATTERN, ENTITY, entity);
        entity = sittingRepository.save(entity);

        saveSittingPaintRelation(entity.getSittingId(), paints);
        saveSittingNeedleRelation(entity.getSittingId(), needles);

        return super.modelBuilder.createSittingModel(entity);
    }

    public GenericResponse deleteById(Long id) {
        var sittingId = idValidatorService.sittingIdValidation(id);
        deleteForeignKeyService.deleteSittingPaintRelationBySittingId(sittingId);
        deleteForeignKeyService.deleteSittingNeedleRelationBySittingId(sittingId);
        sittingRepository.deleteById(sittingId);
        return GenericResponse.OK;
    }

    private void saveSittingPaintRelation(Long sittingId, List<Long> paints){
        if(paints != null){
            paints.forEach(paint -> idValidatorService.paintIdValidation(paint));
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
            needles.forEach(needle -> idValidatorService.needleIdValidation(needle));
            needles.forEach(needle -> {
                var entity = (SittingNeedle) entityFactory.getObject(SittingNeedle.class.getSimpleName());
                entity.setSittingIdFk(sittingId);
                entity.setNeedleIdFk(needle);
                sittingNeedleRepository.save(entity);
            });
        }
    }

}
