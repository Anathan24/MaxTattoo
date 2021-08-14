package com.maxtattoo.controller;

import com.maxtattoo.command.StatisticCommand;
import com.maxtattoo.pojo.statistic.TotalStatisticWrapper;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping(value = "/statistic")
public class StatisticController extends GenericController{

    @GetMapping(value = "calculateStatisticByPeriod", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TotalStatisticWrapper> calculateStatisticByPeriod(@RequestParam String startDate, @RequestParam String endDate){
        logger.info(START);
        var command = super.beanFactory.getBean(StatisticCommand.class);
        logger.info("{} = StartDate: {}, EndDate: {}",REQUEST, startDate, endDate);
        var statistic = command.calculateStatisticByPeriod(startDate,endDate);
        logger.info(MESSAGE_PATTERN, MODEL, statistic);
        logger.info(END);
        return ok(statistic);
    }
}
