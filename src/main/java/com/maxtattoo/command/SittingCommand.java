package com.maxtattoo.command;

import com.maxtattoo.model.SittingModel;
import com.maxtattoo.service.SittingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class SittingCommand extends GenericCommand{

    @Autowired
    private SittingService sittingService;

    public SittingModel findSittingById(Long id){
        return sittingService.findSittingById(id);
    }

    public Long createSittingNeedleRelation(Long sittingId, Long needleId){
        return sittingService.createSittingNeedleRelation(sittingId, needleId);
    }

    public Long createSittingPaintRelation(Long sittingId, Long paintId){
        return sittingService.createSittingPaintRelation(sittingId, paintId);
    }
}
