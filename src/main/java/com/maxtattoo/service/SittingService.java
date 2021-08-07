package com.maxtattoo.service;

import com.maxtattoo.database.repository.SittingNeedleRepository;
import com.maxtattoo.database.repository.SittingPaintRepository;
import com.maxtattoo.database.repository.SittingRepository;
import com.maxtattoo.exception.ResourceNotFoundException;
import com.maxtattoo.pojo.model.SittingModel;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import static com.maxtattoo.utils.ErrorMessage.FIND_BY_ID;

@Service
public class SittingService extends GenericService{

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
            throw new ResourceNotFoundException(super.buildErrorMessage(FIND_BY_ID, id), HttpStatus.NOT_FOUND);
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
