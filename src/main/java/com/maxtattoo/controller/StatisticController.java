package com.maxtattoo.controller;

import com.maxtattoo.command.StatisticCommand;
import com.maxtattoo.model.statistic.TotalStatisticWrapper;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping(value = "/statistic", produces = {MediaType.APPLICATION_JSON_VALUE, "application/hal+json"})
public class StatisticController extends GenericController{

    @GetMapping(value = "calculateStatisticByPeriod")
    public ResponseEntity<TotalStatisticWrapper> calculateStatisticByPeriod(@RequestParam String startDate, @RequestParam String endDate){
        var statisticCommand = super.beanFactory.getBean(StatisticCommand.class);
        var statistic = statisticCommand.calculateStatisticByPeriod(startDate,endDate);
        return ok(statistic);
    }
}
