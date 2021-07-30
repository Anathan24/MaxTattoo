package com.maxtattoo.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    private static final String DATE_FORMAT = "yyyy-MM-dd";
    private static final String DATE_TIME_FORMAT = "HH:mm:ss yy-MM-dd";

    private DateUtils(){}

    public static String getNow(){
        return new SimpleDateFormat(DATE_TIME_FORMAT).format(new Date());
    }

    public static java.sql.Date getDateFromString(String date){
        Date parsedDate = null;
        try {
            parsedDate = new SimpleDateFormat(DATE_FORMAT).parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if(parsedDate == null)
            throw new NullPointerException("Parsed date is null!");

        return new java.sql.Date(parsedDate.getTime());
    }
}
