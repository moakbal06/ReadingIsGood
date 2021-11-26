package com.erkan.reading.is.good.util;

public class RIGUtils {
    private static String mon[]={"January", "February", "March","April", "May", "June", "July", "August", "September", "October", "November", "December"};

    public static String getYear(String val) {
        String year = val.substring(val.length() - 4);
        return year;
    }

    public static String getMonth(String val) {
        String month = val.substring(0, val.length() - 4);
        return mon[Integer.parseInt(month) - 1];
    }
}
