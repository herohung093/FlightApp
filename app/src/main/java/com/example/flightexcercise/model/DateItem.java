package com.example.flightexcercise.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * DateItem to create date Group
 * */
public class DateItem extends ListItem {
/**
 * we use LocalDateTime instead of String because we can use LocalDateTime to compare and sort DateItem.
 * */
    private LocalDateTime date;

    public DateItem(String stringDate) {
        this.date = LocalDateTime.parse(stringDate);
    }

    public LocalDateTime getDate() {
        return date;
    }
/**
 *  Convert LocalDateTime object to String with format E, dd MMM. Ex: Mon, 15, AUGUST
 * */
    public String getStringDate() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("E, dd MMMM");
        return date.format(dateTimeFormatter).toUpperCase();
    }

    public void setDate(String date) {
        this.date = LocalDateTime.parse(date);
    }

    @Override
    public int getType() {
        return TYPE_DATE;
    }
}
