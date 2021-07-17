package com.maxtattoo.controller;

import com.maxtattoo.command.PaintCommand;
import com.maxtattoo.model.PaintModel;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping(value = "/paint", produces = {MediaType.APPLICATION_JSON_VALUE, "application/hal+json"})
public class PaintController extends GenericController{

    @GetMapping(value = "/findById")
    public ResponseEntity<PaintModel> findById(@RequestParam Long id){
        var paintCommand = super.beanFactory.getBean(PaintCommand.class);
        var paintModel = paintCommand.findPaindById(id);
        return ok(paintModel);
    }
}
