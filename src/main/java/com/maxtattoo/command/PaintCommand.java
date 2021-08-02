package com.maxtattoo.command;

import com.maxtattoo.model.PaintModel;
import com.maxtattoo.service.PaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class PaintCommand extends GenericCommand{

    @Autowired
    private PaintService paintService;

    public PaintModel findById(Long id){
        return paintService.findById(id);
    }
}
