package com.maxtattoo.command;

import com.maxtattoo.service.SittingPaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class SittingPaintCommand extends GenericCommand{

    @Autowired
    private SittingPaintService sittingPaintService;

    public Long createSittingPaintRelation(Long sittingId, Long paintId){
        return sittingPaintService.createSittingPaintRelation(sittingId, paintId);
    }
}
