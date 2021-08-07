package com.maxtattoo.command;

import com.maxtattoo.pojo.model.NeedleModel;
import com.maxtattoo.service.NeedleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class NeedleCommand extends GenericCommand {

    @Autowired
    private NeedleService needleService;

    public NeedleModel findById(Long id){
        return needleService.findById(id);
    }
}
