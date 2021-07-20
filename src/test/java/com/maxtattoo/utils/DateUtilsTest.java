package com.maxtattoo.utils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.format.DateTimeFormatter;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {DateUtils.class})
public class DateUtilsTest {

    @Autowired
    private DateUtils dateUtils;

    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

    @Test
    public void changeDateTimeToFrontEndFormatTest(){

    }
}
