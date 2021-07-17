package com.maxtattoo.controller;

import com.maxtattoo.command.SittingCommand;
import com.maxtattoo.model.SittingModel;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping(value = "/sitting", produces = {MediaType.APPLICATION_JSON_VALUE, "application/hal+json"})
public class SittingController extends GenericController{

    @GetMapping(value = "/findById")
    public ResponseEntity<SittingModel> findById(@RequestParam Long id){
        var sittingCommand = super.beanFactory.getBean(SittingCommand.class);
        var sittingModel = sittingCommand.findSittingById(id);
        return ok(sittingModel);
    }

    @PutMapping(value = "/createSittingNeedleRelation")
    public ResponseEntity<Long> createSittingNeedleRelation(@RequestParam Long sittingId, @RequestParam Long needleId){
        var sittingCommand = super.beanFactory.getBean(SittingCommand.class);
        var relationId = sittingCommand.createSittingNeedleRelation(sittingId, needleId);
        return ok(relationId);
    }

    @PutMapping(value = "/createSittingPaintRelation")
    public ResponseEntity<Long> createSittingPaintRelation(@RequestParam Long sittingId, @RequestParam Long paintId){
        var sittingCommand = super.beanFactory.getBean(SittingCommand.class);
        var relationId = sittingCommand.createSittingPaintRelation(sittingId, paintId);
        return ok(relationId);
    }
}
