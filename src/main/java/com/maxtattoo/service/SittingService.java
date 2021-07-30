package com.maxtattoo.service;

import com.maxtattoo.database.entity.Sitting;
import com.maxtattoo.database.repository.SittingNeedleRepository;
import com.maxtattoo.database.repository.SittingPaintRepository;
import com.maxtattoo.database.repository.SittingRepository;
import com.maxtattoo.exception.ResourceNotFoundException;
import com.maxtattoo.model.SittingModel;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import static com.maxtattoo.utils.ErrorMessages.FIND_BY_ID;

@Service
public class SittingService extends GenericService{

    private static final String ENTITY_NAME = Sitting.class.getSimpleName();

    @Autowired
    private SittingRepository sittingRepository;
    @Autowired
    private SittingNeedleRepository sittingNeedleRepository;
    @Autowired
    private SittingPaintRepository sittingPaintRepository;

    public SittingModel findById(Long id){
        var result = sittingRepository.findById(id);

        if(result.isPresent())
            return super.modelBuilder.createSittingModel(result.get());
        else
            throw new ResourceNotFoundException(FIND_BY_ID.getValue().concat(super.buildEntityId(ENTITY_NAME, id)));
    }

    public Long createSittingNeedleRelation(Long sittingId, Long needleId){
        //TODO da gestire l'inserimento di una relazione N a N
        //return sittingNeedleRepository.save(new SittingNeedle(sittingId, needleId)).getSittingNeedleId();
        return null;
    }


    public Long createSittingPaintRelation(Long sittingId, Long paintId){
        //TODO da gestire l'inserimento di una relazione N a N
        //return sittingPaintRepository.save(new SittingPaint(sittingId, paintId)).getSittingPaintId();
        return null;
    }
}
