package com.maxtattoo.service;

import com.maxtattoo.database.entity.SittingPaint;
import com.maxtattoo.database.repository.SittingPaintRepository;
import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class SittingPaintService extends GenericService{

    @Autowired
    private SittingPaintRepository sittingPaintRepository;

    public Long createSittingPaintRelation(Long sittingId, Long paintId){
        return sittingPaintRepository.save(new SittingPaint(sittingId, paintId)).getSittingPaintId();
    }
}
