package com.maxtattoo.controller;

import com.maxtattoo.command.StatisticCommand;
import com.maxtattoo.dto.statistic.MonthOfYearStatisticModel;
import com.maxtattoo.dto.statistic.TotalStatisticWrapper;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.maxtattoo.utils.StringUtils.*;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping(value = "/statistic")
public class StatisticController extends GenericController {

    @GetMapping(value = "getStatisticByPeriod", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TotalStatisticWrapper> getStatisticByPeriod(@RequestParam String startDate, @RequestParam String endDate) {
        logger.info(START);
        var command = super.beanFactory.getBean(StatisticCommand.class);
        logger.info("{} = StartDate: {}, EndDate: {}",REQUEST, startDate, endDate);
        var statistic = command.getStatisticByPeriod(startDate,endDate);
        logger.info(MESSAGE_PATTERN, MODEL, statistic);
        logger.info(END);
        return ok(statistic);
    }

    @GetMapping(value = "/getStatisticByYear", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<MonthOfYearStatisticModel>> getStatisticByYear(@RequestParam String year) {
        logger.info(START);
        var command = super.beanFactory.getBean(StatisticCommand.class);
        logger.info(MESSAGE_PATTERN, REQUEST, year);
        var result = command.getStatisticByYear(year);
        logger.info("RESULT: {}", result);
        logger.info(END);
        return ok(result);
    }
}
