package com.fmr.myofficework.util;

import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {

    public static Date stringToDateConverter(String date) throws Exception {
        Date date1 = new SimpleDateFormat("dd-MM-yyyy").parse(date);
        return date1;
    }

    public static Time convertStringToSqlTime(String time) throws Exception {
        DateFormat formatter = new SimpleDateFormat("HH:mm");
        java.sql.Time timeValue = new java.sql.Time(formatter.parse(time).getTime());
        return timeValue;
    }

    public String appendEveryLetterOfString(String word) {
        String[] strArr = word.split("");
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : strArr) {
            stringBuilder.append(s.charAt(0));
        }
        String newValue = stringBuilder.toString();
        return newValue;
    }


}
