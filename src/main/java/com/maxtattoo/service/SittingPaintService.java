package com.maxtattoo.service;

import com.maxtattoo.database.entity.SittingPaint;
import com.maxtattoo.database.repository.SittingPaintRepository;
import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class SittingPaintService extends GenericService{

    @Autowired
    private SittingPaintRepository sittingPaintRepository;

    public SittingPaint createSittingPaintRelation(Long sittingId, Long paintId){
        SittingPaint relation = new SittingPaint(sittingId, paintId);
        return sittingPaintRepository.save(relation);
    }
}
