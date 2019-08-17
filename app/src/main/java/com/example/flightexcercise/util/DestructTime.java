package com.example.flightexcercise.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DestructTime {
    static LocalDateTime dateTime;
    public static String getDate(String fullTime){
        dateTime = LocalDateTime.parse(fullTime);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("E, dd MMM");
        return dateTime.format(dateTimeFormatter).substring(0,dateTime.format(dateTimeFormatter).length()-1);
    }
    public  static String getTime(String fullTime){
        dateTime = LocalDateTime.parse(fullTime);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("hh:mm a");
        return dateTime.format(dateTimeFormatter).toUpperCase();
    }
}
