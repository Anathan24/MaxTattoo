package com.maxtattoo.service;

import com.maxtattoo.database.repository.SittingNeedleRepository;
import com.maxtattoo.database.repository.SittingPaintRepository;
import com.maxtattoo.database.repository.SittingRepository;
import com.maxtattoo.model.SittingModel;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class SittingService extends GenericService{

    @Autowired
    private SittingRepository sittingRepository;
    @Autowired
    private SittingNeedleRepository sittingNeedleRepository;
    @Autowired
    private SittingPaintRepository sittingPaintRepository;

    public SittingModel findSittingById(Long id){
        var sitting = sittingRepository.findSittingById(id);
        return super.modelBuilder.createSittingModel(sitting);
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
