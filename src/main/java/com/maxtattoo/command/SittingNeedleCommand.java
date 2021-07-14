package com.maxtattoo.command;

import com.maxtattoo.service.SittingNeedleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class SittingNeedleCommand extends GenericCommand{

    @Autowired
    private SittingNeedleService sittingNeedleService;

    public Long createSittingNeedleRelation(Long sittingId, Long needleId){
        return sittingNeedleService.createSittingNeedleRelation(sittingId, needleId);
    }
}
