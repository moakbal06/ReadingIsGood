package com.onur.reading.util;

import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.GregorianCalendar;

public class RIGUtils {
    private static String mon[]={"January", "February", "March","April", "May", "June", "July", "August", "September", "October", "November", "December"};

    public static String getYear(String val) throws ParseException {
        Date date = DateUtils.parseDate(val,"yyyy-MM-dd HH:mm:SS.ssssss");
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(date);
        int year = cal.get(GregorianCalendar.YEAR);
        return String.valueOf(year);
    }

    public static String getMonth(String val) throws ParseException {
        Date date = DateUtils.parseDate(val,"yyyy-MM-dd HH:mm:SS.ssssss");
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(date);
        int month1 = cal.get(GregorianCalendar.MONTH);

        return mon[month1 - 1];
    }
}
