package com.maxtattoo.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    private static final String DATE_FORMAT = "yyyy-MM-dd";

    private DateUtils(){}

    public static java.sql.Date getDateFromString(String date){
        Date parsedDate = null;
        try {
            parsedDate = new SimpleDateFormat(DATE_FORMAT).parse(date);
        } catch (ParseException e) {
            //TODO gestire l'eccezione relativa al fornmato della data
            e.printStackTrace();
        }
        if(parsedDate == null)
            throw new NullPointerException("Parsed date is null!");

        return new java.sql.Date(parsedDate.getTime());
    }
}
