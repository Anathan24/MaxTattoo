package com.maxtattoo.controller;

import com.maxtattoo.command.SittingNeedleCommand;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping(value = "/sittingNeedle", produces = {MediaType.APPLICATION_JSON_VALUE, "application/hal+json"})
public class SittingNeedleController extends GenericController{

    @PutMapping(value = "/createSittingNeedleRelation")
    public ResponseEntity<Long> createSittingNeedleRelation(@RequestParam Long sittingId, @RequestParam Long needleId){
        var sittingNeedleCommand = super.beanFactory.getBean(SittingNeedleCommand.class);
        var relationId = sittingNeedleCommand.createSittingNeedleRelation(sittingId, needleId);
        return ok(relationId);
    }
}
