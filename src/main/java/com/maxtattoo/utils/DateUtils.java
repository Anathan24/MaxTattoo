package com.maxtattoo.utils;

import com.maxtattoo.exception.DateFormatException;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.regex.Pattern;

public class DateUtils {
    private static final Logger logger = LoggerFactory.getLogger(DateUtils.class.getSimpleName());
    private static final String DATE_FORMAT = "yyyy-MM-dd";
    private static final String DATE_TIME_FORMAT = "yy-MM-dd HH:mm";

    private DateUtils(){}

    public static String getNow(){
        return new SimpleDateFormat(DATE_TIME_FORMAT).format(new Date(System.currentTimeMillis()));
    }

    @SneakyThrows
    public static Date getDateFromString(String date){
        final String dateFormat = "\\d{4}-\\d{2}-\\d{2}";

        if(!Pattern.matches(dateFormat, date)) {
            String message = "Wrong date format! The format must be: " + DATE_FORMAT;
            logger.warn(message);
            throw new DateFormatException(message, HttpStatus.NOT_ACCEPTABLE);
        }
        return new Date(new SimpleDateFormat(DATE_FORMAT).parse(date).getTime());
    }

    @SneakyThrows
    public static Timestamp getTimestampFromString(String dateTime) {
        final String dateTimeFormat = "\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}";

        if(!Pattern.matches(dateTimeFormat, dateTime)) {
            String message = "Wrong date time format! The format must be: " + DATE_TIME_FORMAT;
            logger.warn(message);
            throw new DateFormatException(message, HttpStatus.NOT_ACCEPTABLE);
        }
        return new Timestamp(new SimpleDateFormat(DATE_TIME_FORMAT).parse(dateTime).getTime());
    }
}
