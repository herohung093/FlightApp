package com.example.flightexcercise.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
/**
 * This class is to convert time from Json format to desired format
 * */
public class DestructTime {
    static LocalDateTime dateTime;
    /**
     * @param fullTime a String of Json time object
     * @return a String in format "E, dd MMM "
     * */
    public static String getDate(String fullTime){
        if(fullTime == null || fullTime.equals(""))
            return "N/A";
        dateTime = LocalDateTime.parse(fullTime);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("E, dd MMM");
        return dateTime.format(dateTimeFormatter);
    }
    /**
     * @param fullTime a String of Json time object
     * @return a String in format "hh:mm a". for hour and minute
     * */
    public  static String getTime(String fullTime){
        if(fullTime == null || fullTime.equals(""))
            return "N/A";
        dateTime = LocalDateTime.parse(fullTime);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("hh:mm a");
        return dateTime.format(dateTimeFormatter).toUpperCase();
    }

}
