package com.maxtattoo.utils;

import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@Service
public class DateUtils {

    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    private final ZoneId zone = ZoneId.of("Europe/Berlin");

    public LocalDateTime getNow(){
        return LocalDateTime.now(zone);
    }

    public LocalDateTime localDateTimeFromTimeStamp(Timestamp dateTime){
        return dateTime.toLocalDateTime();
    }

    public LocalDateTime localDateTimeFromString(String dateTime){
        return LocalDateTime.parse(dateTime, dateTimeFormatter);
    }

    public Timestamp timestampFromLocalDateTIme(LocalDateTime dateTime){
        return Timestamp.valueOf(dateTime);
    }
}
