package com.maxtattoo.utils;

import com.maxtattoo.exception.DateFormatException;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.regex.Pattern;

import static com.maxtattoo.utils.ErrorMessage.WRONG_DATE_FORMAT;

public class DateUtils {

    private static final String DATE_FORMAT = "yyyy-MM-dd";
    private static final String DATE_TIME_FORMAT = "HH:mm:ss yy-MM-dd";

    private DateUtils(){}

    public static String getNow(){
        return new SimpleDateFormat(DATE_TIME_FORMAT).format(new Date(System.currentTimeMillis()));
    }

    @SneakyThrows
    public static Date getDateFromString(String date){
        String regex = "\\d{4}-\\d{2}-\\d{2}";

        if(!Pattern.matches(regex, date))
            throw new DateFormatException(WRONG_DATE_FORMAT.getValue().concat(" The format must be: "+DATE_FORMAT), HttpStatus.NOT_ACCEPTABLE);

        return new Date(new SimpleDateFormat(DATE_FORMAT).parse(date).getTime());
    }

    @SneakyThrows
    public static Timestamp getTimestampFromString(String date){
        //TODO da implementare il passaggio da stringa a timestamp
        return new Timestamp(new SimpleDateFormat(DATE_TIME_FORMAT).parse(date).getTime());
    }
}
