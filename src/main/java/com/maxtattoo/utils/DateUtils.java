package com.maxtattoo.utils;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class DateUtils {

    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    private static final String EUROPE_ROME = "Europe/Rome";

    private DateUtils(){}

    public static LocalDateTime getLocalDateTimeFrom(Long mills) {
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(mills), ZoneId.of(EUROPE_ROME));
    }

    public static Long getLongFromLocalDateTime(LocalDateTime dateTime) {
        return dateTime.atZone(ZoneId.of(EUROPE_ROME)).toInstant().toEpochMilli();
    }

    public static String getStringFromLocalDateTime(LocalDateTime dateTime) {
        return dateTime.format(dateTimeFormatter);
    }

    public static LocalDate getLocalDateFromString(String date){
        return (date != null)? LocalDate.parse(date, dateTimeFormatter) : null;
    }

    public static String getStringFromLocalDate(LocalDate date){
        return date.format(dateTimeFormatter);
    }

    public LocalDateTime localDateTimeFromTimeStamp(Timestamp dateTime) {
        return dateTime.toLocalDateTime();
    }

    public LocalDateTime localDateTimeFromString(String dateTime) {
        return LocalDateTime.parse(dateTime, dateTimeFormatter);
    }

    public Timestamp timestampFromLocalDateTIme(LocalDateTime dateTime) {
        return Timestamp.valueOf(dateTime);
    }
}
