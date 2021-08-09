package com.maxtattoo.command;

import com.maxtattoo.pojo.entity.Paint;
import com.maxtattoo.pojo.model.PaintModel;
import com.maxtattoo.pojo.request.PaintRequest;
import com.maxtattoo.service.PaintService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class PaintCommand extends GenericCommand{

    @Autowired
    private PaintService paintService;

    public PaintModel findById(Long id){
        logger.info("{} id: {}", REQUEST, id);
        return paintService.findById(id);
    }

    public PaintModel savePaint(PaintRequest request){
        logger.info("{}: {}", REQUEST, request);
        var entity = new Paint();
        BeanUtils.copyProperties(request, entity);
        return paintService.savePaint(entity);
    }
}
