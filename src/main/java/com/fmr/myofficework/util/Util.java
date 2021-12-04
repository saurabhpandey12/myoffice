package com.fmr.myofficework.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {

    private static final Logger log = LoggerFactory.getLogger(Util.class);

    public static Date stringToDateConverter(String date) throws Exception {
        Date date1 = new SimpleDateFormat("dd-MM-yyyy").parse(date);
        return date1;
    }

    public static Time convertStringToSqlTime(String time) throws Exception {
       // DateFormat formatter = new SimpleDateFormat("HH:mm");
            Time convertedTime = null;
        try {

         //   SimpleDateFormat format = new SimpleDateFormat("hh:mm a"); //if 24 hour format
            // or
            SimpleDateFormat format = new SimpleDateFormat("HH:mm"); // 12 hour format

            java.util.Date d1 =(java.util.Date)format.parse(time);

            java.sql.Time ppstime = new java.sql.Time(d1.getTime());
            convertedTime = ppstime ;

        } catch(Exception e) {

            log.info("Invalid format of time {}",time);
        }

        return convertedTime;
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
