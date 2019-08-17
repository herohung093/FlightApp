package com.example.flightexcercise.model;
/**
 * Abstract class for Flight item and Date item. The purpose is to put create the common recycle list
 * */
public abstract class ListItem {
    public static final int TYPE_DATE = 0;
    public static final int TYPE_GENERAL = 1;

    abstract public int getType();
}
