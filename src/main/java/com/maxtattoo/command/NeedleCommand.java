package com.maxtattoo.command;

import com.maxtattoo.pojo.entity.Needle;
import com.maxtattoo.pojo.model.NeedleModel;
import com.maxtattoo.pojo.request.NeedleRequest;
import com.maxtattoo.service.NeedleService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class NeedleCommand extends GenericCommand {

    @Autowired
    private NeedleService needleService;

    public NeedleModel findById(Long id){
        logger.info("{} id: {}", REQUEST, id);
        return needleService.findById(id);
    }

    public NeedleModel saveNeedle(NeedleRequest request){
        logger.info("{}: {}", REQUEST, request);
        var entity = new Needle();
        BeanUtils.copyProperties(request, entity);
        return needleService.saveNeedle(entity);
    }
}
