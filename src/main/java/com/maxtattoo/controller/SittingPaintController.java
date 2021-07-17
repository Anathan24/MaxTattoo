package com.maxtattoo.controller;

import com.maxtattoo.command.SittingPaintCommand;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping(value = "/sittingPaint", produces = {MediaType.APPLICATION_JSON_VALUE, "application/hal+json"})
public class SittingPaintController extends GenericController{

    @PutMapping(value = "/createSittingPaintRelation")
    public ResponseEntity<Long> createSittingPaintRelation(@RequestParam Long sittingId, @RequestParam Long paintId){
        var sittingPaintCommand = super.beanFactory.getBean(SittingPaintCommand.class);
        var relationId = sittingPaintCommand.createSittingPaintRelation(sittingId, paintId);
        return ok(relationId);
    }
}
